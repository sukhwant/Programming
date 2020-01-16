package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum2 {


    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum3(3, 9));
    }

    private void backtrack(int currK, int totalK, int target, int[] currResult,
        List<List<Integer>> result, int currIndex, int[] nums) {

        if (currK == totalK) {
            //System.out.println(Arrays.toString(currResult));
            if (Arrays.stream(currResult).sum() == target) {
                List<Integer> temp = Arrays.stream(currResult).boxed().collect(Collectors.toList());
                result.add(temp);
            }
            return;
        }

        for (int i = currIndex; i < nums.length; i++) {
            currResult[currK] = nums[i];
            backtrack(currK + 1, totalK, target, currResult, result, i + 1, nums);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(0, k, n, new int[k], result, 0, nums);
        return result;
    }
}
