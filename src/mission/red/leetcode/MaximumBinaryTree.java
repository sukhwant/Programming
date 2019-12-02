package mission.red.leetcode;
/**
 * https://leetcode.com/problems/maximum-binary-tree/submissions/
 * 
 * @author sukhwanp
 *
 */

public class MaximumBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	private TreeNode constructSubTree(int[] input, int start, int end) {

		if (start > end) {
			return null;
		} else if (start == end) {
			return new TreeNode(input[start]);
		} else {
			int max = input[start];
			int maxIndex = start;
			for (int i = start; i <= end; i++) {
				if (max < input[i]) {
					max = input[i];
					maxIndex = i;
				}
			}

			// Create Node for max
			TreeNode node = new TreeNode(input[maxIndex]);
			// left
			node.left = constructSubTree(input, start, maxIndex - 1);
			node.right = constructSubTree(input, maxIndex + 1, end);
			return node;
		}

	}

	public TreeNode constructMaximumBinaryTree(int[] input) {
		return constructSubTree(input, 0, input.length - 1);
	}

	public static void main(String[] args) {
		int[] input = { 3, 2, 1, 6, 0, 5 };

		TreeNode node = new MaximumBinaryTree().constructMaximumBinaryTree(input);
		System.out.println("hello World");
	}

}
