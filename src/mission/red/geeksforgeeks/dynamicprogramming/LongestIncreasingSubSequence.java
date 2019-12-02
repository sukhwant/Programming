package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * 
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * 
 * O(n log n) -
 * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * 
 * @author sukhwanp
 *
 */
public class LongestIncreasingSubSequence {

    public static int LIS(int arr[]) {

        int[] ans = new int[arr.length];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            ans[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    ans[i] = Math.max(ans[i], 1 + ans[j]);
                }
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 5 };

        System.out.println("Answer is - " + LIS(input));

    }

}
