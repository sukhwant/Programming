package leetcode.mission.red;
import java.util.stream.IntStream;

public class KEqualSumPartition {

    public boolean canPartitionKSubsets(int[] input, int k) {

        int totalSum = IntStream.of(input).sum();

        if (totalSum % k != 0) {
            return false;
        }

        int sum = totalSum / k;

        int[][] result = new int[sum + 1][input.length + 1];

        // Base case
        for (int i = 0; i <= input.length; i++) {
            result[0][i] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            result[i][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= input.length; j++) {
                int include = 0;
                int exclude = 0;
                // Exclude
                include = result[i][j - 1];

                // Include
                if (i >= input[j - 1]) {
                    exclude = result[i - input[j - 1]][j - 1];
                }
                result[i][j] = include + exclude;
            }
        }
        return result[sum][input.length] >= k;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2, 3, 4, 5 };
        int k = 4;

        System.out.println(new KEqualSumPartition().canPartitionKSubsets(nums, k));
    }

}
