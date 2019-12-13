package mission.red.leetcode.medium;

import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class InOrderTraversal {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);

        root.right.left = new TreeNode(-1);
        root.right.right = new TreeNode(-1);

        System.out.println("Hello World");
    }

    // TODO:
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
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
