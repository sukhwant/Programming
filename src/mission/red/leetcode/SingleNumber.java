package mission.red.leetcode;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum ^= nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] input = {2, 2, 1};
        System.out.println(new SingleNumber().singleNumber(input));
    }
}
