package mission.red.leetcode;
public class BinaryTreePruning {

    /**
     * https://leetcode.com/problems/binary-tree-pruning/submissions/
     *
     * @author sukhwanp
     *
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            // it's a leaf node.
            if(root.val == 0)
                return null;
            else
                return root;
        } else {
            // Not a leaft node.
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);

            // Check if root can be pruned.
            if (root.left == null && root.right == null && root.val == 0) {
                return null;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        root = pruneTree(root);

        System.out.println("Hello World");

    }

}
