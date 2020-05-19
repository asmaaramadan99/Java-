package classes;

import java.util.NoSuchElementException;

import interfaces.IDictionary;

public class TreeDictionary<K extends Comparable<K>, V> implements IDictionary<K, V> {
	private BinaryTreeNode root;
	private V deletedValue;

	private class Pair {
		K key;
		V value;

		Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	@SuppressWarnings("unchecked")
	public BinaryTreeNode find(K key, BinaryTreeNode root) {

		
		if (root == null || ((Pair) root.element).key.compareTo(key) == 0)
			return root;

		
		if (((Pair) root.element).key.compareTo(key) > 0)
			return find(key, root.left);

		return find(key, root.right);
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		if (key == null)
			throw new NoSuchElementException("invalid");
		BinaryTreeNode node = find(key, this.root);
		if (node == null)
			return null;
		@SuppressWarnings("unchecked")
		Pair p = (TreeDictionary<K, V>.Pair) node.element;

		if (p.value == null)
			return null;

		return p.value;
	}

	@SuppressWarnings("unchecked")
	public Pair getMin(BinaryTreeNode root) {
		if (root.left == null)
			return ((Pair) root.element);

		return getMin(root.left);

	}

	@SuppressWarnings("unchecked")
	public BinaryTreeNode delete(BinaryTreeNode root, K key) {

		if (root == null)
			return root;
		Pair p = (TreeDictionary<K, V>.Pair) root.element;
		if (key.compareTo(p.key) < 0)
			root.left = delete(root.left, key);
		else if (key.compareTo(p.key) > 0)
			root.right = delete(root.right, key);
		else {
			if (root.right == null && root.left == null) {
				if (deletedValue == null) {
					deletedValue = p.value;
				}
				root = null;

			} else if (root.left == null) {
				if (deletedValue == null) {
					deletedValue = p.value;
				}
				@SuppressWarnings("unused")
				BinaryTreeNode temp = root;
				root = root.right;
				temp = null;

			} else if (root.right == null) {
				if (deletedValue == null) {
					deletedValue = p.value;
				}
				@SuppressWarnings("unused")
				BinaryTreeNode temp = root;
				root = root.left;
				temp = null;

			} else {
				p = (TreeDictionary<K, V>.Pair) root.element;
				if (deletedValue == null) {
					deletedValue = p.value;
				}
				Pair temp = getMin(root.right);
				((Pair) root.element).key = temp.key;
				((Pair) root.element).value = temp.value;
				root.right = delete(root.right, temp.key);
			}
		}

		return root;

	}

	@SuppressWarnings("unchecked")
	public BinaryTreeNode insert(BinaryTreeNode root, Pair p) {

		if (root == null) {
			root = new BinaryTreeNode(p);
			return root;

		} else if (p.key.compareTo(((Pair) root.element).key) < 0) {
			root.left = insert(root.left, p);
		} else if (p.key.compareTo(((Pair) root.element).key) > 0) {
			root.right = insert(root.right, p);
		}
		return root;

	}

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub

		if (key == null || value == null)
			throw new NoSuchElementException();
		V element = get(key);
		if (element == null) {
			Pair p = new Pair(key, value);
			this.root = insert(this.root, p);

		} else {

			BinaryTreeNode temp = find(key, root);
			@SuppressWarnings("unchecked")
			Pair p = (TreeDictionary<K, V>.Pair) temp.element;
			V oldValue = p.value;
			p.value = value;
			return oldValue;

		}

		return null;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		if (key == null)
			throw new NoSuchElementException();
		deletedValue = null;
		this.root = delete(this.root, key);
		if (deletedValue != null) {
			return deletedValue;
		} else
			return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.root == null ? true : false;
	}

}
