package leetcode.mission.red;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 * 
 * @author sukhwanp
 *
 */
public class RangeSumOfBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public int rangeSumBST(TreeNode root, int L, int R) {
			return findSum(root, L, R);

		}

		private int findSum(TreeNode root, int L, int R) {
			if (root == null) {
				return 0;
			}
			int sum = 0;
			if (root.val >= L && root.val <= R) {
				sum += root.val;
			}

			if (root.val <= L) {
				return sum + findSum(root.right, L, R);
			}
			if (root.val >= R) {
				return sum + findSum(root.left, L, R);
			}

			else {
				return sum + findSum(root.right, L, R) + findSum(root.left, L, R);
			}
		}
	}
}
