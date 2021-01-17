package mission.red.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


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
            if(temp.node == null)
                continue;
            levelMap.computeIfAbsent(temp.level, k -> new LinkedList<>()).add(temp.node.val);
            queue.add(new QueueNode(temp.node.left, temp.level + 1));
            queue.add(new QueueNode(temp.node.right, temp.level + 1));
        }
        return new ArrayList<>(levelMap.values());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15),
            new TreeNode(7)));
        System.out.println(new LevelOrder().levelOrder(root));
    }
}
