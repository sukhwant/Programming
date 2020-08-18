package mission.red.leetcode.medium;

public class WiggleSequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;

        int prevDirection = Integer.signum(nums[1] - nums[0]);

        for (int i = 2; i < nums.length; i++) {
            int currDirection = Integer.signum(nums[i] - nums[i-1]);
            if(currDirection != prevDirection){
                count++;
                prevDirection = currDirection;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = {3,3,3,2,5};
        System.out.println(new WiggleSequence().wiggleMaxLength(input));
    }
}
