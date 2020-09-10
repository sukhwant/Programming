package mission.red.leetcode.easy;

public class MaxDepth {

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

    public int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        dfs(root, 0);
        return maxDepth;
    }

    private void dfs(final TreeNode root, final int depth) {

        if(root == null){
            maxDepth = Math.max(maxDepth, depth);
            return;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public static void main(String[] args) {

    }

}
