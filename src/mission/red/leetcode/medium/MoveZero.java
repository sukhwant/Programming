package mission.red.leetcode.medium;

public class MoveZero {

    public void moveZeroes(int[] nums) {
        int k= 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[k++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        new MoveZero().moveZeroes(input);
        System.out.println("Hello");
    }
}
