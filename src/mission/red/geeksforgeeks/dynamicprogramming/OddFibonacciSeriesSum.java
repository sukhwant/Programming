package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/find-the-sum-of-first-n-odd-fibonacci-numbers/
 * 
 * Solution :- a(n) = a(n-1) + 4*a(n-2) – 4*a(n-3) + a(n-4) – a(n-5) for n>5
 * 
 * @author sukhwanp
 *
 */
public class OddFibonacciSeriesSum {

    // private static final double PRIME = Math.pow(10, 9) + 7;

    public static int oddFibbonacciSum(int n) {

        int[] sum = new int[n + 1];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        sum[3] = 5;
        sum[4] = 10;

        for (int i = 5; i <= n; i++) {
            sum[i] = sum[i - 1] + 4 * sum[i - 2] - 4 * sum[i - 3] + sum[i - 4] - sum[i - 5];
        }

        return sum[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(oddFibbonacciSum(n));
    }

}
