package javatutorial.datastructure;

import javatutorial.datastructure.exceptions.EmptyListException;
import javatutorial.datastructure.exceptions.EmptyStackException;

public class Stack<T> {

    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T element) {
        list.add(element);
    }

    public T pop() {
        try {
            return list.removeFromFront();
        } catch (EmptyListException e) {
            throw new EmptyStackException("Stack is Empty...");
        }
    }
}
