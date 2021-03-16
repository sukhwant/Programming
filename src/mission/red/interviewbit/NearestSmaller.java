package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmaller {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> input) {

        ArrayList<Integer> leftSmall = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        leftSmall.add(-1);
        stack.push(0);
        for (int i = 1; i < input.size(); i++) {
            if (input.get(stack.peek()) < input.get(i)) {
                leftSmall.add(stack.peek());
                stack.push(i);
            } else {
                while (!stack.isEmpty() && input.get(stack.peek()) >= input.get(i)) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    leftSmall.add(-1);
                } else {
                    leftSmall.add(stack.peek());
                }
                stack.push(i);
            }
        }
        return leftSmall;
    }
}
