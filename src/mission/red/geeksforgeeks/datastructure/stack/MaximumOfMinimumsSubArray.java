package mission.red.geeksforgeeks.datastructure.stack;

/**
 * https://www.geeksforgeeks.org/maximum-sum-of-smallest-and-second-smallest-in-an-array/
 * 
 * @author sukhwanp
 *
 */
public class MaximumOfMinimumsSubArray {

    public static void main(String args[]) {
        int[] input = { 4, 3, 1, 5, 6 };

        System.out.println(maximumOfMinimums(input));

    }

    private static int maximumOfMinimums(int[] input) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < input.length; i++) {
            max = Math.max(max, input[i - 1] + input[i]);
        }
        return max;
    }
}
