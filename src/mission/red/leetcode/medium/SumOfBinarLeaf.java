package mission.red.leetcode.medium;

public class SumOfBinarLeaf {

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

    public static int sum = 0;

    public static void dfs(TreeNode root, String currPath){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            // Leaf node found... Update sum
            sum = sum + stringToBinary(currPath + root.val);
            return;
        }

        dfs(root.left, currPath + root.val);
        dfs(root.right, currPath + root.val);
    }

    private static int stringToBinary(final String s) {
        return Integer.parseInt(s, 2);
    }

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, "");
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(new SumOfBinarLeaf().sumRootToLeaf(root));
    }
}
