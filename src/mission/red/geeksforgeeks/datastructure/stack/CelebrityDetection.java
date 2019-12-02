package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-celebrity-problem/ -> More problem to solve
 * on this pages's recommendation.
 * 
 * @author sukhwanp
 *
 */
public class CelebrityDetection {

    private static int celebrityDetection(int[][] answer) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < answer.length; i++) {
            stack.push(i);
        }

        int guest1, guest2;
        while (stack.size() > 1) {
            guest1 = stack.pop();
            guest2 = stack.pop();

            if (answer[guest1][guest2] == 1) {
                stack.push(guest2);
            } else {
                stack.push(guest1);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        int[][] answer = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

        System.out.println(celebrityDetection(answer));

    }

}
