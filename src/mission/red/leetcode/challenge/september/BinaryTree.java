package mission.red.leetcode.challenge.september;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public class TreeNode {
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        traverseTree(root1, list1);
        traverseTree(root2, list2);

        List<Integer> it1 = list1;
        List<Integer> it2 = list2;

        return result;
    }

    private void traverseTree(final TreeNode root, final List<Integer> list) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        traverseTree(root.left, list);
        list.add(root.val);
        traverseTree(root.right, list);
    }

    public static void main(String[] args) {

    }
}
