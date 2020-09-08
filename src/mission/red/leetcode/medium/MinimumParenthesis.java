package mission.red.leetcode.medium;

import java.util.Stack;

public class MinimumParenthesis {

    public int minInsertions(String s) {

        if(s.isEmpty()){
            return 0;
        }
        Stack<Character> stack = new Stack();
        int rightCount = 0;
        int leftCount = 0;

        String input = s.replace("))", "]");
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '('){
                stack.push(input.charAt(i));
            }
            if(input.charAt(i) == ')'){
                leftCount++;
                if(stack.isEmpty())
                    leftCount++;
                else
                    stack.pop();
            }
            if(input.charAt(i) == ']'){
                if(stack.isEmpty())
                    leftCount++;
                else
                    stack.pop();
            }
        }
        rightCount = stack.size() * 2;
        return leftCount + rightCount;
    }

    public static void main(String[] args) {

        System.out.println(new MinimumParenthesis().minInsertions("())"));
    }

}
