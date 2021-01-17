package mission.red.leetcode.challenge.september;

//TODO:
public class ContigousMaxProduct {


    // O(n^2)
    public int maxProduct(int[] nums) {

        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int res = nums[i];
            maxProduct = Math.max(maxProduct, res);
            for (int j = i+1; j < nums.length ; j++) {
                res = res * nums[j];
                //System.out.println(res);
                maxProduct = Math.max(maxProduct, res);
            }
        }
        return maxProduct;
    }

    public int maxProduct2(int[] nums) {

        int maxProduct = Integer.MIN_VALUE;

        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;

            currMax = Math.max(currMax, temp);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] input = {-2};
        System.out.println(new ContigousMaxProduct().maxProduct(input));
    }
}
