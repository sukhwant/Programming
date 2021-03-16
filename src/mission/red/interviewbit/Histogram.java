package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class Histogram {

    public int largestRectangleArea(ArrayList<Integer> input) {

        int leftSmall[] = new int[input.size()];
        int rightSmall[] = new int[input.size()];

        Stack<Integer> stack = new Stack<>();
        rightSmall[input.size() - 1] = input.size();
        stack.push(input.size() - 1);

        for (int i = input.size() - 2; i >= 0; i--) {
            if (input.get(stack.peek()) < input.get(i)) {
                rightSmall[i] = stack.peek();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && input.get(stack.peek()) >= input.get(i)) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    rightSmall[i] = input.size();
                } else {
                    rightSmall[i] = stack.peek();
                }
                stack.push(i);
            }
        }

        stack = new Stack<>();
        leftSmall[0] = -1;
        stack.push(0);
        for (int i = 1; i < input.size(); i++) {
            if (input.get(stack.peek()) < input.get(i)) {
                leftSmall[i] = stack.peek();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && input.get(stack.peek()) >= input.get(i)) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    leftSmall[i] = -1;
                } else {
                    leftSmall[i] = stack.peek();
                }
                stack.push(i);
            }
        }

        int max = 0;
        for (int i = 0; i < input.size(); i++) {

            int temp = input.get(i) * (rightSmall[i] - leftSmall[i] - 1);
            max = Math.max(max, temp);
        }

        return max;
    }

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(5);
        input.add(5);
        input.add(5);
        System.out.println(new Histogram().largestRectangleArea(input));

    }
}
