package mission.red.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class RepeatedNTimes {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 4, 4};
        System.out.println(new RepeatedNTimes().repeatedNTimes(input));
    }

    public int repeatedNTimes(int[] input) {
        Map<Integer, Boolean> isPresent = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            if(isPresent.containsKey(input[i])){
                return input[i];
            }
            isPresent.put(input[i], Boolean.TRUE);
        }
        return 0;
    }
}
