package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/reduce-a-number-to-1-by-performing-given-operations/
 * 
 * @author sukhwanp
 *
 */
public class ReduceNumberToOne {

    public static int reduce(int n, int ans[]) {

        if (ans[n] != -1) {
            return ans[n];
        }
        System.out.println(n);
        if (n % 2 == 0) {
            ans[n] = reduce(n / 2, ans) + 1;
            return ans[n];
        } else {
            ans[n] = Math.min(reduce(n + 1, ans), reduce(n - 1, ans)) + 1;
            return ans[n];
        }
    }

    public static void main(String[] args) {
        int n = 15;
        int[] ans = new int[n + 2];
        Arrays.fill(ans, -1);
        ans[1] = 0;
        System.out.println(reduce(n, ans));
    }

}
