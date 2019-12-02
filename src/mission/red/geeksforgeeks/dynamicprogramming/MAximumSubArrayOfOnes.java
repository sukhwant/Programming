package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * 
 * @author sukhwanp
 *
 */
public class MAximumSubArrayOfOnes {

    public static void main(String[] args) {
        int input[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 } };

        System.out.println(maxSubSquare(input));
    }

    private static int maxSubSquare(int[][] input) {
        int[][] ans = new int[input.length][input[0].length];

        int max = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {

                if (i == 0 || j == 0) {
                    ans[i][j] = input[i][j];
                } else if (input[i][j] == 1) {
                    ans[i][j] = Math.min(ans[i - 1][j - 1], Math.min(ans[i - 1][j], ans[i][j - 1])) + 1;
                } else {
                    ans[i][j] = 0;
                }
                max = Math.max(max, ans[i][j]);
            }
        }
        return max;
    }
}
