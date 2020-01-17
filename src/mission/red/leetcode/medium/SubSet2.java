package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubSet2 {

    public static void main(String[] args) {
        int[] input = {1, 2, 2};
        System.out.println(new SubSet2().subsetsWithDup(input));
    }

    private void backtrack(int[] input, Set<List<Integer>> result, int totalLength, int currLength,
        Integer[] currList, int currIndex) {
        if (currLength == totalLength) {
            List<Integer> temp = Arrays.stream(currList).sorted().collect(Collectors.toList());
            System.out.println(temp);
            result.add(temp);
            return;
        }

        for (int i = currIndex; i < input.length; i++) {
            currList[currLength] = input[i];
            backtrack(input, result, totalLength, currLength + 1, currList, i + 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backtrack(nums, result, i, 0, new Integer[i], 0);
        }

        return new LinkedList<>(result);
    }
}
