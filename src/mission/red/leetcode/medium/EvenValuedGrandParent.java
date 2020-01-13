package mission.red.leetcode.medium;

public class EvenValuedGrandParent {

    private int sum = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        System.out.println(new EvenValuedGrandParent().sumEvenGrandparent(root));
    }

    private void bfs(TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null) {
            return;
        }
        if (grandParent != null && (grandParent.val % 2 == 0)) {
            sum += node.val;
        }

        bfs(node.left, node, parent);
        bfs(node.right, node, parent);
    }

    public int sumEvenGrandparent(TreeNode root) {

        bfs(root, null, null);
        return sum;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
