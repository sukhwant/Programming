package mission.red.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.stream.Collectors;


public class LevelOrder {

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

    public static class QueueNode{
        TreeNode node;
        int level;

        public QueueNode(final TreeNode node, final int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, 1));

        while (!queue.isEmpty()) {
            QueueNode temp = queue.remove();
            levelMap.computeIfAbsent(temp.level, k -> new LinkedList<>()).add(temp.node.val);

            if (temp.node != null) {
                queue.add(new QueueNode(temp.node.left, temp.level + 1));
                queue.add(new QueueNode(temp.node.right, temp.level + 1));

            }
        }
        return new ArrayList<>(levelMap.values());
    }

    public static void main(String[] args) {

    }
}
