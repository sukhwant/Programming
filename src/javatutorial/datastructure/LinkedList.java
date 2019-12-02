package javatutorial.datastructure;

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

    /**
     * Add an element to the list.
     *
     * @param element element to be added.
     */
    public void add(T element) {
        if (head == null) {
            head = new LinkedListNode(element);
        } else {
            LinkedListNode node = new LinkedListNode(element);
            node.next = head;
            head = node;
        }
    }

    /**
     * Add a list of elements to the list.
     *
     * @param elements elements to add.
     */
    public void addAll(List<T> elements) {
        for(T element: elements){
            this.add(element);
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


    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
