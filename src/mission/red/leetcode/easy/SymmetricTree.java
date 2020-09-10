package mission.red.leetcode.easy;

public class SymmetricTree {

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
    public void checkSymmetry(TreeNode left, TreeNode right){

        if(left == null && right == null){
            return;
        }

        if(left == null || right == null){
            result = false;
            return;
        }
        if(left.val != right.val){
            result = false;
            return;
        }

        checkSymmetry(left.left, right.right);
        checkSymmetry(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        result = true;
        checkSymmetry(root.left, root.right);
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        System.out.println(new SymmetricTree().isSymmetric(root));
    }

}
