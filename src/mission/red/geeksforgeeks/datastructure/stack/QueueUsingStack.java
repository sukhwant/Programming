package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/queue-using-stacks/
 * 
 * @author sukhwanp
 *
 * @param <T>
 */
public class QueueUsingStack<T> {

    Stack<T> stackOne;
    Stack<T> stackTwo;

    public QueueUsingStack() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public void enqueue(T element) {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }

        stackOne.push(element);
        while (!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }
    }

    public T dequeue() {
        return stackTwo.pop();
    }
}
