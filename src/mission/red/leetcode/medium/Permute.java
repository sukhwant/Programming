package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Permute {

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        System.out.println(new Permute().permute(input));
    }

    private void backTrack(int[] nums, boolean[] visited, List<List<Integer>> result,
        Stack<Integer> currList) {
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                found = true;
                visited[i] = true;
                currList.push(nums[i]);
                backTrack(nums, visited, result, currList);
                visited[i] = false;
                currList.pop();
            }
        }
        if (!found) {
            result.add(new LinkedList<>(currList));
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, new boolean[nums.length], result, new Stack<>());
        return result;
    }

}
