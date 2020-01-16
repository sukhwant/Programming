package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubSets {

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        System.out.println(new SubSets().subsets(input));
    }

    private void backtrack(int[] input, List<List<Integer>> result, int totalLength, int currLength,
        Integer[] currList, int currIndex) {
        if (currLength == totalLength) {
            List<Integer> temp = Arrays.stream(currList).collect(Collectors.toList());
            result.add(temp);
            return;
        }

        for (int i = currIndex; i < input.length; i++) {
            currList[currLength] = input[i];
            backtrack(input, result, totalLength, currLength + 1, currList, i + 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backtrack(nums, result, i, 0, new Integer[i], 0);
        }
        return result;
    }
}
