package dataStructures;

import interfaces.IStack;

public class Stack implements IStack {

    private class Node {
        private Object element;
        private Node next;

        Node(Object element) {
            setElement(element);

        }
        public Object getElement() {
            return element;
        }
        public void setElement(Object element) {
            this.element = element;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

    }

    private int size;
    private Node top;

    @Override
    public Object pop() {
        if (isEmpty())
            throw new RuntimeException();
        Object value = top.getElement();
        top = top.getNext();
        size--;
        return value;
    }

    @Override
    public Object peek() {
        if (isEmpty())
            throw new RuntimeException();

        return top.getElement();
    }

    @Override
    public void push(Object element) {
        if (isEmpty()) {
            Node data = new Node(element);
            top = data;
            size++;
        } else {
            Node data = new Node(element);
            data.setNext(top);
            top = data;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {

        return size == 0 ? true : false;
    }

    @Override
    public int size() {

        return size;
    }

}