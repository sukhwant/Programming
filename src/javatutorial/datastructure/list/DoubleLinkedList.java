package javatutorial.datastructure.list;

import javatutorial.datastructure.exceptions.EmptyListException;

public class DoubleLinkedList<T> {

    private class LinkedListNode {
        private T data;
        private LinkedListNode next;
        private LinkedListNode previous;

        public LinkedListNode(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private LinkedListNode head = null;
    private LinkedListNode tail = null;

    public void add(T element) {
        LinkedListNode node = new LinkedListNode(element);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    public T removeFromFront() {
        if (head == null) {
            throw new EmptyListException("List is empty.");
        }
        LinkedListNode node = head;
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        node.next = node.previous = null;
        return node.data;
    }

    public T removeFromEnd() {
        if (head == null) {
            throw new EmptyListException("List is empty.");
        }
        LinkedListNode node = tail;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        node.next = node.previous = null;
        return node.data;
    }

    public void iterate() {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
