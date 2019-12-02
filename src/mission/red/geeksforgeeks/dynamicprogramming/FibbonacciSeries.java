package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * 
 * @author sukhwanp
 *
 */
public class FibbonacciSeries {

    public static int fibboRecursive(int n, int[] arr) {

        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = fibboRecursive(n - 1, arr) + fibboRecursive(n - 2, arr);
        return arr[n];
    }

    public static int fibboIterative(int n, int[] arr) {

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 8;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 1;
        arr[1] = 1;
        System.out.println(fibboIterative(n, arr));
    }
}
