package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/next-greater-element/
 * 
 * @author sukhwanp
 *
 */
public class NextGreaterElement {

    private static int[] nextGreater(int[] input) {

        int[] answer = new int[input.length];
        Stack<Integer> stack = new Stack<>();

        answer[input.length - 1] = -1;
        stack.push(input[input.length - 1]);

        for (int i = input.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && input[i] > stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }

            stack.push(input[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 13, 21, 3 };
        int[] answer = nextGreater(arr);
        for (int i : answer) {
            System.out.println(i);
        }
    }

}
