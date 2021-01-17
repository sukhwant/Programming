package mission.red.leetcode.medium;

/**
 *
 * https://leetcode.com/problems/minimum-path-sum/
 *
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int[][] result = new int[grid.length][grid[0].length];

        result[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            result[i][0] = result[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            result[0][i] = result[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                result[i][j] = Math.min(grid[i][j] + result[i-1][j], grid[i][j] + result[i][j-1]);
            }
        }

        return result[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2, 3},{4, 5, 6}};

        System.out.println(new MinimumPathSum().minPathSum(grid));
    }
}
