package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * 
 * @author sukhwanp
 *
 */
public class StockSpan {

    private static int[] stockSpan(int[] input) {

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[input.length];

        ans[0] = 1;
        stack.push(0);
        for (int i = 1; i < input.length; i++) {
            if (input[i] < input[stack.peek()]) {
                stack.push(i);
                ans[i] = 1;
            } else {
                while (!stack.isEmpty() && input[i] > input[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.empty()) {
                    ans[i] = i - stack.peek();
                } else {
                    ans[i] = i + 1;
                }
                stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = { 100, 80, 60, 70, 60, 75, 85 };
        int[] ans = stockSpan(input);

        for (int i : ans) {
            System.out.println(i);
        }

    }

}
