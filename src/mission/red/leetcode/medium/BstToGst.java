package mission.red.leetcode.medium;

public class BstToGst {

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {

        if(root == null)
            return root;

        bstToGst(root.right);
        root.val = sum + root.val;

        bstToGst(root.left);

        return root;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
