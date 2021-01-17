package mission.red.leetcode.easy;

public class MaximumConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int start = -1;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1 && start == -1){
                start = i;
            } else if(nums[i] == 1 && start != -1){
                continue;
            } else if(nums[i] == 0 && start != -1){
                length = Math.max(length, (i-start));
                start = -1;
            }
        }

        if(start != -1)
            length = Math.max(length, nums.length - start);
        return length;
    }

    public static void main(String[] args) {
        int[] input = {1,1,0,1,1,1};
        System.out.println(new MaximumConsecutiveOnes().findMaxConsecutiveOnes(input));
    }
}
