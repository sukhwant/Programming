package mission.red.leetcode.medium;

import lombok.val;

class BST {

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
    public TreeNode helper(TreeNode root, int val){
        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }
        if(val > root.val){
            return helper(root.right, val);
        }
        return helper(root.left, val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
            return helper(root, val);
    }

    public static void main(String[] args) {

    }
}
