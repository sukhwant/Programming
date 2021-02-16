package mission.red.leetcode.medium;

import java.util.stream.IntStream;

public class GreatestSumDivisionByThree {

    public int maxSumDivThree(int[] nums) {

        int oneMin = Integer.MAX_VALUE;
        int twoMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 1)
                oneMin = Math.min(oneMin, nums[i]);
            if (nums[i] % 3 == 2)
                twoMin = Math.min(twoMin, nums[i]);
        }

        int result = IntStream.of(nums).sum();
        if(result%3 == 0)
            return result;
        if(result % 3 == 1)
            return result - oneMin;
        if(result % 3 == 2)
            return result - twoMin;
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};

        System.out.println(new GreatestSumDivisionByThree().maxSumDivThree(nums));
    }
}
