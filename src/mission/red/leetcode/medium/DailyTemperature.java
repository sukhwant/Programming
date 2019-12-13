package mission.red.leetcode.medium;

import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(new DailyTemperature().dailyTemperatures(input));
    }

    public int[] dailyTemperatures(int[] input) {
        int[] result = new int[input.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                result[i] = 0;
            } else {
                while (!stack.isEmpty() && input[stack.peek()] <= input[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result[i] = 0;
                } else {
                    result[i] = stack.peek() - i;
                }
                stack.push(i);
            }
        }
        return result;
    }

}
