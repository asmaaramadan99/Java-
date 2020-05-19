package classes;

import dataStructures.Stack;
import interfaces.IMiscUtils;

public class MiscUtils implements IMiscUtils {

	public void traverse(BinaryTreeNode root) {
		if (root == null)
			return;
		traverse(root.left);
		System.out.println(root.element);
		traverse(root.right);
	}

	@Override
	public BinaryTreeNode insert(BinaryTreeNode root, int element) {
		// TODO Auto-generated method stub

		if (root == null) {
			root = new BinaryTreeNode(element);
			return root;

		} else if (element < (int) root.element) {
			root.left = insert(root.left, element);
		} else if (element > (int) root.element) {
			root.right = insert(root.right, element);
		}
		return root;
	}

	public BinaryTreeNode search(BinaryTreeNode root, int key) {
		if ((int) root.element == key)
			return root;
		else if (key < (int) root.element)
			return search(root.left, key);
		else if (key > (int) root.element)
			return search(root.right, key);
		return null;

	}

	@Override
	public int sumRange(BinaryTreeNode root, int low, int high) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		if ((int) root.element < low)
			return sumRange(root.right, low, high);
		if ((int) root.element > high)
			return sumRange(root.left, low, high);

		return (int) root.element + sumRange(root.left, low, high) + sumRange(root.right, low, high);

	}

	@Override
	public boolean isValidBST(BinaryTreeNode root) {
		// TODO Auto-generated method stub

		if (root == null)
			return true;
		if ((root.left != null && (int) root.element < getMax(root.left))
				|| (root.right != null && (int) root.element > getMin(root.right)))
			return false;

		if (isValidBST(root.left) && isValidBST(root.right))
			return true;
		return false;

	}

	static public int getMin(BinaryTreeNode root) {
		if (root.left == null)
			return (int) root.element;

		return getMin(root.left);

	}

	public int getMax(BinaryTreeNode root) {
		if (root.right == null)
			return (int) root.element;

		return getMax(root.right);

	}

	@Override
	public int[] nextSmallerNumber(int[] array) {
		// TODO Auto-generated method stub
		if (array == null)
			throw new RuntimeException();
		int[] result = new int[array.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		Stack stack = new Stack();

		for (int i = 0; i < array.length; i++) {
			while (!stack.isEmpty() && array[(int) stack.peek()] > array[i]) {
				result[(int) stack.pop()] = i;
			}
			stack.push(i);
		}
		return result;
	}
}
