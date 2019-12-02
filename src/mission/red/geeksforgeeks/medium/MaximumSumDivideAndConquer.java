package mission.red.geeksforgeeks.medium;

/**
 * https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
 * 
 * @author sukhwanp
 *
 */
public class MaximumSumDivideAndConquer {

    private static int maxSum(int[] input, int start, int end) {
        if (start == end) {
            return input[start];
        } else {
            int mid = (start + end) / 2;
            int leftAns = maxSum(input, start, mid);
            int rightAns = maxSum(input, mid + 1, end);
            int mergeAns = merge(input, start, mid, end);
            return Math.max(Math.max(leftAns, rightAns), mergeAns);
        }
    }

    private static int merge(int[] input, int start, int mid, int end) {
        int leftSum = 0;
        int rightSum = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for (int i = mid; i >= start; i--) {
            leftSum += input[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        for (int i = mid + 1; i <= end; i++) {
            rightSum += input[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }

    public static int maximumSum(int[] input) {
        return maxSum(input, 0, input.length - 1);
    }

    public static void main(String[] args) {
        int[] input = { 2, 3, 4, 5, 7 };
        System.out.println(maximumSum(input));
    }

}
