package javatutorial.datastructure;

import javatutorial.datastructure.exceptions.EmptyListException;
import javatutorial.datastructure.exceptions.EmptyQueueException;

public class Queue<T> {

    private DoubleLinkedList<T> list;

    public Queue() {
        list = new DoubleLinkedList<>();
    }

    public void enque(T element) {
        list.add(element);
    }

    public T dequeue() {
        try {
            return list.removeFromEnd();
        } catch (EmptyListException e) {
            throw new EmptyQueueException("Queue is Empty.");
        }
    }
}
