package mission.red.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AllElements {

    public static void main(String[] args) {
        System.out.println(new AllElements().getAllElements(new TreeNode(1), new TreeNode(2)));
    }

    private void bfs(TreeNode node, List<Integer> numbers) {
        if (node == null) {
            return;
        }
        numbers.add(node.val);
        bfs(node.left, numbers);
        bfs(node.right, numbers);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> numbers = new LinkedList<>();
        bfs(root1, numbers);
        bfs(root1, numbers);
        Collections.sort(numbers);
        return numbers;
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
