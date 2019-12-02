package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * kadane Algorithm
 * 
 * @author sukhwanp
 *
 */
public class LatgestSumContigousSubArray {

    private static int kadane(int[] input) {
        int max = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < input.length; i++) {
            maxEndingHere = maxEndingHere + input[i];

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }

            max = Math.max(max, maxEndingHere);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(kadane(input));
    }

}
