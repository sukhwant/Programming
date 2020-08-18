package mission.red.leetcode.medium;

public class IncreasingTriplet {

    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean leftSmall = false;
            boolean rightlarge = false;

            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    leftSmall = true;
            }
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] < nums[j])
                    rightlarge = true;
            }
            if(leftSmall && rightlarge)
                return true;
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        boolean[] leftSmall = new boolean[nums.length];
        boolean[] rightLarge = new boolean[nums.length];

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(smallest < nums[i])
                leftSmall[i] = true;
            smallest = Math.min(smallest, nums[i]);
        }
        for (int i = nums.length-1; i > 0; i--) {
            if(largest > nums[i])
                rightLarge[i] = true;
            largest = Math.max(largest, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if(leftSmall[i] && rightLarge[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        System.out.println(new IncreasingTriplet().increasingTriplet2(input));
    }
}
