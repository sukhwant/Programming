package mission.red.leetcode;
public class LongestUnivaluePath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int longestUnivaluePath(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftAns = longestUnivaluePath(root.left);
            int rightAns = longestUnivaluePath(root.right);

            if (root.left != null && root.val == root.left.val && root.right != null
                    && root.val == root.right.val) {
                return Math.max(leftAns, rightAns) + 1;
            } else if (root.left != null && root.val == root.left.val) {
                return leftAns + 1;
            } else if (root.right != null && root.val == root.right.val) {
                return rightAns + 1;
            } else {
                return Math.max(leftAns, rightAns);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left = new TreeNode(4);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(5);

        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }

}
