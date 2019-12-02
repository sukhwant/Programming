/**
 * 
 */
package mission.red.leetcode;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/number-recycled-pairs-array/
 * 
 * @author sukhwanp
 *
 */
public class RecycledPair {

    public int recycledPairs(int[] input) {
        Arrays.sort(input);
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            int temp = input[i];
            int numDigit = 0;
            while (temp > 0) {
                numDigit++;
                temp /= 10;
            }
            int divisor = (int) Math.pow(10, numDigit);
            for (int j = 0; j < numDigit; j++) {
                int number = (input[i] % 10) * divisor + input[i] / 10;
                if (Arrays.binarySearch(input, number) >= 0) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] input = {};
        new RecycledPair().recycledPairs(input);
    }

}
