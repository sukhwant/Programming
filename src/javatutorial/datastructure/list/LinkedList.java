package javatutorial.datastructure.list;

import java.util.List;

import javatutorial.datastructure.exceptions.EmptyListException;

public class LinkedList<T> {

    private class LinkedListNode {
        private T data;
        private LinkedListNode next;

         LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private LinkedListNode head = null;
    private LinkedListNode tail = null;

    /**
     * Add an element to the list.
     *
     * @param element element to be added.
     */
    public void addFront(T element) {
        if (head == null) {
            head = new LinkedListNode(element);
            tail = head;
        } else {
            LinkedListNode node = new LinkedListNode(element);
            node.next = head;
            head = node;
        }
    }

    public void addLast(T element) {
        if (head == null) {
            head = new LinkedListNode(element);
            tail = head;
        } else {
            LinkedListNode node = new LinkedListNode(element);
            tail.next = node;
            tail = node;
        }
    }

    /**
     * Add a list of elements to the list.
     *
     * @param elements elements to add.
     */
    public void addAllFront(List<T> elements) {
        for(T element: elements){
            this.addFront(element);
        }
    }

    /**
     * Add a list of elements to the list.
     *
     * @param elements elements to add.
     */
    public void addAllLast(List<T> elements) {
        for(T element: elements){
            this.addLast(element);
        }
    }

    /**
     * Remove element from front of the list.
     *
     * @return the removed element
     */
    public T removeFromFront() {
        if (head == null) {
            throw new EmptyListException("List is Empty");
        }
        LinkedListNode node = head;
        head = head.next;
        return node.data;
    }

    /**
     * Print the list
     */
    public void print() {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
