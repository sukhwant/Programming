package mission.red.leetcode.medium;


import javax.swing.tree.TreeNode;

public class FlattenList {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int x) {
            val = x;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static TreeNode listNode = null;

    static void printInorderBinaryTree(TreeNode root)
    {
        if (root == null)
            return;
        printInorderBinaryTree(root.left);
        System.out.print( root.val + " ");
        printInorderBinaryTree(root.right);
    }

    public static void flatten(TreeNode root) {

        if(root == null){
            return;
        }

        if(root != listNode){
            listNode.right = root;
            listNode = root;
        }

        flatten(root.left);
        flatten(root.right);

        if(root.left == null && root.right == null){
            listNode = root;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        printInorderBinaryTree(root);

        listNode = root;
        flatten(root);

        printInorderBinaryTree(root);
    }
}
