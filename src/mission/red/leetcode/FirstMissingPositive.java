package mission.red.leetcode;

/**
 * https://leetcode.com/problems/first-missing-positive/submissions/
 * 
 * @author sukhwanp
 *
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] input = { 3, 4, 6, 1, 2 };

        FirstMissingPositive solution = new FirstMissingPositive();

        System.out.println(solution.firstMissingPositive(input));
    }

    private int firstMissingPositive(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] <= 0) {
                input[i] = input.length + 1;
            }
        }

        for (int i = 0; i < input.length; i++) {
            int currElement = Math.abs(input[i]);
            if (currElement <= input.length) {
                input[currElement - 1] = input[currElement - 1] > 0 ? -1 * input[currElement - 1]
                        : input[currElement - 1];
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                return i + 1;
            }
        }
        return input.length + 1;
    }

    private void printInput(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
