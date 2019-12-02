package mission.red.leetcode;

// TODO:-
public class HouseRobber {

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length + 1];
        result[0] = 0;
        result[1] = nums[1];
        for (int i = 1; i < nums.length; i++) {
            int include, exclude;
            result[i] = Math.max(result[i - 2] + nums[i], result[i - 1]);
        }
        return result[nums.length];
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        System.out.println(new HouseRobber().rob(input));
    }

}
