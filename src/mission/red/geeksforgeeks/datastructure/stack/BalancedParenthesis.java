package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * 
 * @author sukhwanp
 *
 */
public class BalancedParenthesis {

    private static Boolean checkBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (input.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (input.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "{()}[]";

        System.out.println(checkBalanced(input));

    }

}
