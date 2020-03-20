package eg.edu.alexu.csd.datastructure.linkedList.cs29_cs32;

public class SinglyLinkedList implements ILinkedList {

	public class Node {

		private Object data;
		private Node next;

		Node(Object data) {
			this.setData(data);
		}
		//unparameterized constructor
		public Node() {}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
	}

	public Node head;
	public int size = 0;

	public void InsertHead(Object element) {
		Node New = new Node(element);
		New.setNext(head);
		head = New;

	}

	@Override
	public void add(int index, Object element) {
		if (index == 0 && isEmpty() == true) {
			head = new Node(element);
			size++;
		} else if (index == 0 && size != 0) {
			InsertHead(element);
			size++;

		} else if (index > 0 && isEmpty() == false) {
			Node current = head;
			for (int i = 0; i<index - 1; i++) {
				if (current.getNext() != null) {
					current = current.next;
				}
			}
			Node New = new Node(element);
			New.setNext(current.getNext());
			current.setNext(New);
			size++;

		} else {
			throw new IllegalArgumentException("invalid index");
		}

	}

	//insert at tail
	@Override
	public void add(Object element) {
		if (isEmpty() == false) {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			Node New = new Node(element);
			current.setNext(New);
			New.setNext(null);
		} else {
			head = new Node(element);
			size++;
		}
	}

	@Override
	public Object get(int index) {
		if (index > size || index<0)
			throw new RuntimeException();
		Node x = new Node();
		x = head;
		int i = 0;
		while (i<index) {
			if (x.getNext() != null) {
				i++;
				x = x.next;
			}
		}
		return x.getData();

	}

	public boolean checkValidIndex(int index) {
		if (index >= 0 && index<size)
			return true;
		else
			return false;

	}

	@Override
	public void set(int index, Object element) {

		if (index > size() || index<0)
			throw new RuntimeException();
		else if (index == 0 && size() == 0) {
			head = new Node();
			head.setData(element);;
		} else {
			Node x = new Node();
			x = head;
			int i = 0;
			while (i<index) {
				if (x.next != null) {
					i++;
					x = x.next;
				}
			}
			x.setData(element);;
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		size = 0;

	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	@Override
	public void remove(int index) {

		if (index > size || index<0 || size() == 0)
			throw new RuntimeException();
		else if (index == 0 && size() == 1)
			head = null;
		else if (index == 0 && size() > 1)
			head = head.next;

		else {

			Node current = head;
			int i = 0;
			while (i<index - 1) {
				i++;
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());

		}
		size--;

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		SinglyLinkedList SubList = new SinglyLinkedList();
		Node temp = head;
		int i;
		int j;
		SubList.size = 0;

		if (isEmpty() == true) {
			return null;
		} else {
			for (i = 0; i<fromIndex; i++) {
				if (temp.getNext() != null)
					temp = temp.getNext();
			}
			Node headSubList = new Node(temp.getData());
			SubList.head = headSubList;
			SubList.size++;

			for (j = i; j<toIndex; j++) {
				if (temp.getNext() != null) {
					temp = temp.getNext();

					SubList.add(j, temp.getData());

				}
			}

		}

		return SubList;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub

		Node current = head;
		while (current != null) {
			if (o.equals(current.getData()))
				return true;
			current = current.next;

		}
		return false;

	}

	public void show() {
		Node current = head;
		while (current != null) {
			System.out.println(current.getData().toString());
			current = current.getNext();
		}
	}
}


