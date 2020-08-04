package mission.red.leetcode.medium;

class SumRootTOLeaf {

    private static int currSum = 0;

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

    private static void dfs(TreeNode root, int currValue){

        if(root.left == null && root.right == null){
            currSum += currValue * 10 + root.val;
            System.out.println("Curr Sum " + currSum);
            System.out.println("Curr value " + currValue);
            return;
        }
            dfs(root.left, currValue * 10 + root.val);
            dfs(root.right, currValue * 10 + root.val);
    }
    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return currSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)),
            new TreeNode(0));
           TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int value = sumNumbers(root);
        System.out.println("NUmber is: " + value);
    }
}
