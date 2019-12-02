package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 * 
 * @author sukhwanp
 *
 */
public class NextSmallerElement {

    private static int[] previousSmaller(int[] input) {

        int[] answer = new int[input.length];
        Stack<Integer> stack = new Stack<>();

        answer[0] = -1;
        stack.push(input[0]);

        for (int i = 1; i < input.length; i++) {
            while (!stack.isEmpty() && input[i] < stack.peek()) {
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
        int[] arr = { 1, 6, 4, 10, 2, 5 };
        int[] answer = previousSmaller(arr);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
