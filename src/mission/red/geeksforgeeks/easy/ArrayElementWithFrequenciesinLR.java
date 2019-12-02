package mission.red.geeksforgeeks.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sukhwanp
 *
 *         https://www.geeksforgeeks.org/find-array-elements-with-frequencies-in-range-l-r/
 * 
 */
public class ArrayElementWithFrequenciesinLR {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 2, 2, 5 };
        int l = 2;
        int r = 3;

        Map<Integer, Integer> frequencyTable = new HashMap<>();

        for (Integer i : arr) {
            if (frequencyTable.get(i) != null) {
                frequencyTable.put(i, frequencyTable.get(i) + 1);
            } else {
                frequencyTable.put(i, 1);
            }
        }
        for (Integer i : arr) {
            if (frequencyTable.get(i) >= l && frequencyTable.get(i) <= r) {
                System.out.println(i);
            }
        }
    }

}
