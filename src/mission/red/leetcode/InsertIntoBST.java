package mission.red.leetcode;
/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * 
 * @author sukhwanp
 *
 */
public class InsertIntoBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode root = null;

		InsertIntoBST bst = new InsertIntoBST();
		root = bst.insertIntoBST(root, 4);
		root = bst.insertIntoBST(root, 2);
		root = bst.insertIntoBST(root, 7);
		root = bst.insertIntoBST(root, 1);
		root = bst.insertIntoBST(root, 3);

		System.out.println("Hello World");
	}

}
