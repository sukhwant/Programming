package mission.red.leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum
 */
public class FrequentSubTreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);

        System.out.println(new FrequentSubTreeSum().findFrequentTreeSum(null));
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        dfs(root, frequencyMap);
        Integer maxValue = Collections.max(frequencyMap.values());
        List<Integer> frequencies = frequencyMap.entrySet()
            .stream()
            .filter(entry -> entry.getValue().equals(maxValue))
            .map(Entry::getKey)
            .collect(Collectors.toList());

        int[] result = new int[frequencies.size()];
        int k = 0;
        for (Integer f : frequencies) {
            result[k++] = f;
        }
        return result;
    }

    private int dfs(TreeNode root, Map<Integer, Integer> resultMap) {

        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left, resultMap);
        int rightSum = dfs(root.right, resultMap);
        int rootSum = leftSum + rightSum + root.val;

        resultMap.put(rootSum, resultMap.getOrDefault(rootSum, 0) + 1);
        return rootSum;
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
