package mission.red.leetcode;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/submissions/
 * 
 * @author sukhwanp
 *
 */
public class MaxIncreaseToKeepCitySkyline {

	public int maxIncreaseKeepingSkyline(int[][] grid) {

		int[] sideSkyline = findSideSkyLine(grid);
		int[] topSkyline = findTopSkyLine(grid);

		int maxIncrease = 0;

		for (int col = 0; col < grid[0].length; col++) {
			for (int row = 0; row < grid.length; row++) {
				int maxAllowed = Math.min(sideSkyline[row], topSkyline[col]);
				maxIncrease += maxAllowed - grid[row][col];
			}
		}
		return maxIncrease;
	}

	private int[] findTopSkyLine(int[][] grid) {
		int[] result = new int[grid[0].length];
		for (int col = 0; col < grid[0].length; col++) {
			for (int row = 0; row < grid.length; row++) {
				result[col] = Math.max(result[col], grid[row][col]);
			}
		}
		return result;
	}

	private int[] findSideSkyLine(int[][] grid) {
		int[] result = new int[grid.length];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				result[row] = Math.max(result[row], grid[row][col]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MaxIncreaseToKeepCitySkyline solution = new MaxIncreaseToKeepCitySkyline();

		int[][] grid = { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
		System.out.println(solution.maxIncreaseKeepingSkyline(grid));

	}

}
