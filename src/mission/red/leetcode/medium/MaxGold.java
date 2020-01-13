package mission.red.leetcode.medium;

public class MaxGold {

    private int maxSum = 0;

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(new MaxGold().getMaximumGold(grid));
    }

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //System.out.println("start, end: " + i + ", " + j);
                solve(grid, i, j, new boolean[grid.length][grid[0].length], grid[i][j]);
            }
        }

        return maxSum;
    }

    private void solve(final int[][] grid, final int i, final int j, final boolean[][] visited,
        final int sum) {
        //System.out.println("i, j: " + i + ", " + j);
        boolean isRemainingMove = false;
        visited[i][j] = true;
        //choices
        if (j + 1 < grid[0].length && !visited[i][j + 1] && grid[i][j + 1] != 0) {
            isRemainingMove = true;
            solve(grid, i, j + 1, visited, sum + grid[i][j + 1]);
        }

        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] != 0) {
            isRemainingMove = true;
            solve(grid, i, j - 1, visited, sum + grid[i][j - 1]);
        }

        if (i + 1 < grid.length && !visited[i + 1][j] && grid[i + 1][j] != 0) {
            isRemainingMove = true;
            solve(grid, i + 1, j, visited, sum + grid[i + 1][j]);
        }

        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] != 0) {
            isRemainingMove = true;
            solve(grid, i - 1, j, visited, sum + grid[i - 1][j]);
        }
        visited[i][j] = false;

        if (!isRemainingMove) {
            //System.out.println("No moves remaining - " + sum);
            maxSum = Math.max(sum, maxSum);
        }
    }
}
