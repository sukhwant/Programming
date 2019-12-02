package Application;

import datastructure.Stack;

public class TestApplication {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
