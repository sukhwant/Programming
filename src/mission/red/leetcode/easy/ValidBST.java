package mission.red.leetcode.easy;

import javax.swing.tree.TreeNode;

public class ValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    boolean result;

    public boolean isValidBST(TreeNode root) {
        result = true;
        preOrder(root, null, null);
        return result;
    }

    private void preOrder(final TreeNode root, Integer low, Integer high) {
        if(root == null){
            return;
        }

        if((low != null && root.val <= low) || (high != null && root.val >= high)){
            result = false;
            return;
        }

        preOrder(root.left, low, root.val);
        preOrder(root.right, root.val, high);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(1), null);
        System.out.println(new ValidBST().isValidBST(root));
    }
}
