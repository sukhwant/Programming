package mission.red.leetcode.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DeepestLeaveSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        System.out.println(new DeepestLeaveSum().deepestLeavesSum(root));
    }

    private void bfs(TreeNode node, int depth, Map<Integer, Integer> sumMap) {
        if (node == null) {
            return;
        }
        int sum = sumMap.getOrDefault(depth, 0);
        sumMap.put(depth, node.val + sum);

        bfs(node.left, depth + 1, sumMap);
        bfs(node.right, depth + 1, sumMap);
    }

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        bfs(root, 0, sumMap);

        int maxDepth = Collections.max(sumMap.entrySet(),
            Comparator.comparingInt(Map.Entry::getKey)).getKey();
        return sumMap.get(maxDepth);
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
