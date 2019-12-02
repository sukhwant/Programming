package javatutorial.datastructure;

import java.util.List;

import javatutorial.datastructure.exceptions.EmptyListException;

public class CircularLinkedList<T> {

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
     * Add an element to front of the list.
     *
     * @param element element to be added.
     */
    public void add(T element) {
        if (head == null) {
            head = new LinkedListNode(element);
            head.next = head;
        } else {
            LinkedListNode lastNode = getLastNode();
            LinkedListNode node = new LinkedListNode(element);
            node.next = head;
            head = node;
            lastNode.next = head;
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
        LinkedListNode lastNode = getLastNode();
        LinkedListNode node = head;
        head = head.next;
        lastNode.next = head;
        return node.data;
    }

    private LinkedListNode getLastNode(){
        if(head == null){
            return head;
        }
        LinkedListNode temp = head.next;
        while (temp != head) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Print the list
     */
    public void print() {
        if(head == null){
            System.out.println("Empty List....");
            return;
        }
        System.out.println(head.data);
        LinkedListNode temp = head.next;
        while (temp != head) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
