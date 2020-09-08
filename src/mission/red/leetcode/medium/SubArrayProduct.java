package mission.red.leetcode.medium;

public class SubArrayProduct {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int currProduct = 1;
        int[] solution = new int[nums.length];

        if(nums[0] < k){
            solution[0] = 0;
            currProduct = nums[0];
        } else{
            solution[0] = -1;
        }

        for(int i=1;i<nums.length;i++){

            if(currProduct * nums[i] < k){
                if(solution[i-1] == -1){
                    solution[i] = i;
                } else {
                    solution[i] = solution[i - 1];
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new SubArrayProduct().numSubarrayProductLessThanK(nums, k));
    }

}
