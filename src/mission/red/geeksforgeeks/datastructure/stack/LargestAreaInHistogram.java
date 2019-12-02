package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

public class LargestAreaInHistogram {

    private static int largestArea(int[] histogram) {
        int maxArea = 0;
        int tempArea = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < histogram.length; i++) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
                    int top = stack.pop();
                    tempArea = histogram[top] * (i - top);
                    maxArea = Math.max(maxArea, tempArea);
                }
                stack.push(i);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] input = { 6, 2, 5, 4, 5, 1, 6 };

        System.out.println(largestArea(input));

    }

}
