package mission.red.leetcode.easy;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

public class SortedArrayToBST {

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

    public TreeNode sortedHelper(int[] nums, int start, int end){

        if(start < 0 || end < 0|| start >= nums.length || end >= nums.length)
            return null;
        if(start == end){
            return new TreeNode(nums[start], null, null);
        }
        int middle = (end + start)/2;
        TreeNode left = null, right = null;
        if(start <= middle - 1){
            left = sortedHelper(nums, start, middle - 1);
        }
        if(end >= middle + 1){
            right = sortedHelper(nums, middle + 1, end);
        }
        TreeNode root = new TreeNode(nums[middle], left, right);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = sortedHelper(nums, 0, nums.length - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] input = {};
        System.out.println(new SortedArrayToBST().sortedArrayToBST(input));
    }
}
