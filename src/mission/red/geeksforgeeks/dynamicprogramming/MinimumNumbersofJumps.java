package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 * TODO: - Can optimize outer loop once we reach end.
 *
 * @author sukhwanp
 * 
 */
public class MinimumNumbersofJumps {

    private static int minimumJump(int[] input) {

        int[] ans = new int[input.length];

        Arrays.fill(ans, 100);
        ans[0] = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < i + input[i] + 1 && j < input.length; j++) {
                ans[j] = Math.min(ans[i] + 1, ans[j]);
            }
        }

        return ans[input.length - 1];
    }

    public static void main(String[] args) {
        int[] input = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        System.out.println(minimumJump(input));
    }

}
