package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 * 
 * @author sukhwanp
 *
 */
public class MatrixChainMultiplication {

    private static int matrixMultiplication(int[] input) {
        int[][] ans = new int[input.length + 1][input.length + 1];

        for (int i = 0; i < input.length; i++) {
            ans[i][i] = 0;
        }

        for (int length = 2; length < input.length; length++) {
            for (int start = 0; start < input.length - length + 1; start++) {
                int end = start + length - 1;

                if (start == end) {
                    continue;
                }
                ans[start][end] = Integer.MAX_VALUE;

                for (int partition = 0; partition < end; partition++) {
                    ans[start][end] = Math.min(ans[start][end], ans[start][partition] + ans[partition + 1][end]
                            + input[start] * input[partition] * input[end]);
                }
            }
        }
        return ans[0][input.length - 1];
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 3 };
        System.out.println(matrixMultiplication(input));
    }
}
