package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * 
 * @author sukhwanp
 *
 */
public class SubSetSum {

    public static void main(String[] args) {
        int[] input = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;

        System.out.println(subSetSum(input, sum));
    }

    private static boolean subSetSum(int[] input, int sum) {

        boolean[][] result = new boolean[sum + 1][input.length + 1];

        // Base case
        for (int i = 0; i < input.length; i++) {
            result[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            result[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= input.length; j++) {
                boolean include = false;
                boolean exclude = false;
                // Exclude
                include = result[i][j - 1];

                // Include
                if (i >= input[j - 1]) {
                    exclude = result[i - input[j - 1]][j - 1];
                }
                result[i][j] = include || exclude;
            }
        }
        return result[sum][input.length];
    }
}
