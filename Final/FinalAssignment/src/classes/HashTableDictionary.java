package classes;
import java.util.NoSuchElementException;
import dataStructures.SinglyLinkedList;
import interfaces.IDictionary;

public class HashTableDictionary<K, V> implements IDictionary<K, V> {

	private class hashNode {
		K key;
		V value;

		hashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	public boolean keyExists(hashNode Node, K key) {

		return (Node.key.equals(key)) ? true : false;
	}

	private SinglyLinkedList buckets[];
	private int currentSize = 0;
	private int initialSize;

	public HashTableDictionary(int initialSize) {
		if (initialSize <= 0)
			throw new RuntimeException("Invalid Size");
		this.initialSize = initialSize;
		buckets = new SinglyLinkedList[initialSize];

	}

	public int size() {
		return this.currentSize;

	}

	private int getHashIndex(K key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode % initialSize);

	}

	public hashNode getHashNode(SinglyLinkedList list, K key) {
		for (int i = 0; i < list.size(); i++) {
			@SuppressWarnings("unchecked")
			hashNode Node = (HashTableDictionary<K, V>.hashNode) list.get(i);
			if (keyExists(Node, key))
				return Node;
		}
		return null;

	}

	public int getHashNodeIndex(SinglyLinkedList list, K key) {
		for (int i = 0; i < list.size; i++) {
			@SuppressWarnings("unchecked")
			hashNode Node = (HashTableDictionary<K, V>.hashNode) list.get(i);
			if (keyExists(Node, key))
				return i;
		}
		return -1;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.currentSize == 0 ? true : false;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		if (key == null)
			throw new RuntimeException("Invalid");
		int bucketIndex = getHashIndex(key);
		// System.out.println(bucketIndex);
		SinglyLinkedList list = this.buckets[bucketIndex];
		if (list != null) {

			hashNode Node = getHashNode(list, key);

			return Node != null ? Node.value : null;

		}

		return null;
	}

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (key == null || value == null)
			throw new RuntimeException("Invalid");

		V retrieved = get(key);
		int bucketIndex = getHashIndex(key);
		SinglyLinkedList list = this.buckets[bucketIndex];
		if (retrieved == null) {
			hashNode Node = new hashNode(key, value);
			if (list == null) {
				// Make a new list
				this.buckets[bucketIndex] = new SinglyLinkedList();
				this.buckets[bucketIndex].add(Node);
				this.currentSize++;
			} else {

				this.buckets[bucketIndex].add(Node);
				this.currentSize++;
				//

			}
		}

		else {
			hashNode temp = getHashNode(list, key);
			V returned = temp.value;
			temp.value = value;
			return returned;

		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(K key) {
		if (currentSize == 0)
			throw new RuntimeException();
		hashNode node;
		if (key == null)
			throw new NoSuchElementException();
		int bucketIndex = getHashIndex(key);
		SinglyLinkedList list = buckets[bucketIndex];
		if (list == null)
			throw new NoSuchElementException();
		int foundAt = getHashNodeIndex(list, key);
		if (foundAt == -1)
			throw new NoSuchElementException();
		else {
			node = (HashTableDictionary<K, V>.hashNode) list.get(foundAt);
			list.remove(foundAt);
			this.currentSize--;
		}

		return node.value;
	}
}
