package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.Scanner;

/**
 * 
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
 * 
 * @author sukhwanp
 *
 */
public class MaximumSumWithNoAdjacentElement {

    private static int maximumSum(int[] input) {

        int[] ans = new int[input.length + 1];
        ans[0] = 0;
        ans[1] = input[0];

        for (int i = 2; i <= input.length; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + input[i - 1]);
        }
        return ans[input.length];
    }

    public static void main(String[] args) {

        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t-- > 0) {
            int n;
            n = scanner.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextInt();
            }

            // scanner.close();
            System.out.println(maximumSum(input));

        }
    }
}
