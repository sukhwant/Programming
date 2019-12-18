package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/array-of-doubled-pairs
 */
public class DoubledPair {

    public static void main(String[] args) {
        int[] input = {4, -2, 2, -4};

        System.out.println(new DoubledPair().canReorderDoubled(input));
    }

    public boolean canReorderDoubled(int[] input) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int x : input) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        Integer[] boxedInput = Arrays.stream(input)
            .boxed()
            .toArray(Integer[]::new);

        //sort A
        Arrays.sort(boxedInput, Comparator.comparingInt(Math::abs));

        for (int x : boxedInput) {
            //already consumed
            if (countMap.get(x) == 0) {
                continue;
            }
            if (!countMap.containsKey(2 * x) || countMap.get(2 * x) == 0) {
                return false;
            }

            countMap.put(x, countMap.get(x) - 1);
            countMap.put(2 * x, countMap.get(2 * x) - 1);

        }
        return true;
    }
}
