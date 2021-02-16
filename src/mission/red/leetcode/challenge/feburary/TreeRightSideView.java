package mission.red.leetcode.challenge.feburary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeRightSideView {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        traverse(root, result, 1);
        return result;
    }

    private void traverse(final TreeNode root, final List<Integer> result,
        int currLevel) {

        if(root == null){
            return;
        }

        if(result.size() < currLevel){
            result.add(root.val);
        }

        traverse(root.right, result, currLevel + 1);
        traverse(root.left, result, currLevel + 1);
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3,
            null, new TreeNode(4)));
        System.out.println(new TreeRightSideView().rightSideView(root));
    }
}
