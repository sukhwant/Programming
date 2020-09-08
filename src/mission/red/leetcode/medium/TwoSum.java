package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> elementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            elementMap.putIfAbsent(nums[i], new LinkedList<>());
            elementMap.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if(nums[i] == rem){
                if(elementMap.get(nums[i]).size() > 1)
                    return new int[]{elementMap.get(rem).get(0), elementMap.get(rem).get(1)};
            } else if(elementMap.containsKey(rem) && !elementMap.get(rem).isEmpty()){
                return new int[]{i, elementMap.get(rem).get(0)};
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        int[] input = {2, 5, 5, 11};
        int target = 10;
        System.out.println(new TwoSum().twoSum(input, target));
    }
}
