package mission.red.leetcode.medium;

import java.util.Arrays;

public class EqualPartition {

    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums)
            .sum();

        if(sum%2 != 0)
            return false;

        return helper(0, sum/2, nums, new Boolean[sum/2 +1][nums.length]);
    }

    private boolean helper(int index, int sum, int[] nums, Boolean cache[][]){

        if(index >= nums.length || sum<0){
            return false;
        }
        if(sum == 0){
            return true;
        }
        if(cache[sum][index] != null){
            return cache[sum][index];
        }
        cache[sum][index] = helper(index + 1, sum, nums, cache) || helper(index + 1,
        sum - nums[index], nums, cache);
        return cache[sum][index];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,4,5};

        System.out.println(new EqualPartition().canPartition(nums));
    }
}
