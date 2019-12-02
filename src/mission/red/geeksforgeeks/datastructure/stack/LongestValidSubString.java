package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 * 
 * @author sukhwanp
 *
 */
public class LongestValidSubString {

    private static int longestValidString(String input) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        stack.push(-1);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = ")()())";
        System.out.println(longestValidString(input));
    }

}
