package datastructure;

public class Stack {

    private int[] store;
    private int top;

    private static final int MAX_SIZE = 100;

    public Stack() {
        this.store = new int[MAX_SIZE];
        top = 0;
    }

    public void push(int data) {
        if (size() == MAX_SIZE) {
            throw new RuntimeException("Stack is full..");
        }
        store[top] = data;
        top++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty...");
        }
        top--;
        return store[top];
    }

    public int peek() {
        return store[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        return false;
    }
}
