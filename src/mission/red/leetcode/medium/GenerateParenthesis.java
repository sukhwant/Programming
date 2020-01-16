package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    private void backtrack(List<String> results, char[] currString, int currLength,
        int totalLength) {

        if (currLength == totalLength) {
            String temp = new String(currString);
            //System.out.println(temp);
            if (isValid(temp)) {
                results.add(new String(currString));
            }
            return;
        }

        currString[currLength] = '(';
        backtrack(results, currString, currLength + 1, totalLength);
        currString[currLength] = ')';
        backtrack(results, currString, currLength + 1, totalLength);
    }

    private boolean isValid(final String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrackEfficient(result, n, n, 0, new char[2 * n], 0);
        return result;
    }

    private void backtrackEfficient(List<String> result, int leftCount, int rightCount,
        int openParen, char[] currString, int currLength) {

        if (leftCount == 0 && rightCount == 0) {
            result.add(new String(currString));
        }
        if (leftCount > 0) {
            currString[currLength] = '(';
            backtrackEfficient(result, leftCount - 1, rightCount, openParen + 1, currString,
                currLength + 1);
        }

        if (rightCount > 0 && openParen > 0) {
            currString[currLength] = ')';
            backtrackEfficient(result, leftCount, rightCount - 1, openParen - 1, currString,
                currLength + 1);
        }
    }
}