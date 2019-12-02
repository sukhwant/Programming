package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * 
 * @author sukhwanp
 *
 */
public class MinCostPath {

    private static int minCostPath(int[][] input) {
        int[][] ans = new int[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {

                if (i == 0 && j == 0) {
                    ans[i][j] = input[0][0];
                } else if (i == 0) {
                    ans[i][j] = ans[i][j - 1] + input[i][j];
                } else if (j == 0) {
                    ans[i][j] = ans[i - 1][j] + input[i][j];
                } else {
                    ans[i][j] = Math.min(ans[i - 1][j - 1], Math.min(ans[i - 1][j], ans[i][j - 1])) + input[i][j];
                }
            }
        }

        return ans[input.length - 1][input.length - 1];
    }

    public static void main(String[] args) {
        int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

        System.out.print(minCostPath(cost));

    }

}
