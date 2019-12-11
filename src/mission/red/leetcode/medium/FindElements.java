package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree
 */
public class FindElements {

    private Map<Integer, Boolean> isPresent = new HashMap<>();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);

        root.right.left = new TreeNode(-1);
        root.right.right = new TreeNode(-1);

        FindElements tree = new FindElements(root);

        System.out.println("Hello World");
        System.out.println(tree.find(5));
        System.out.println(tree.find(8));
        System.out.println(tree.find(1));

    }

    private void correct(TreeNode node, int nodeVal) {
        if (node == null) {
            return;
        }
        node.val = nodeVal;
        isPresent.put(nodeVal, Boolean.TRUE);

        correct(node.left, nodeVal * 2 + 1);
        correct(node.right, nodeVal * 2 + 2);
    }

    public FindElements(TreeNode root) {
        correct(root, 0);
    }

    public boolean find(int target) {
        return isPresent.containsKey(target);
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
