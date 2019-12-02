package mission.red.geeksforgeeks.easy;

/**
 * 
 * @author sukhwanp
 *
 *         https://www.geeksforgeeks.org/longest-subarray-with-elements-having-equal-modulo-k/
 */
public class LongestSubarrayWithElementsEqualModuloK {

    public static void main(String[] args) {

        int[] arr = { 2, 1, 5, 8, 1 };
        int k = 3;
        int currRemainder = arr[0] % k;
        int currCount = 1;
        int maxCount = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % k == currRemainder) {
                currCount++;
            } else {
                currCount = 1;
            }
            if (maxCount < currCount) {
                maxCount = currCount;
            }
            currRemainder = arr[i] % k;
        }
        System.out.println(maxCount);
    }

}
