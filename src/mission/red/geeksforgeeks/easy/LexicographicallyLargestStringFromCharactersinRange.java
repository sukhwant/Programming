package mission.red.geeksforgeeks.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sukhwanp
 * 
 *         https://www.geeksforgeeks.org/lexicographically-largest-string-formed-from-the-characters-in-range-l-and-r/
 */
public class LexicographicallyLargestStringFromCharactersinRange {

    public static void main(String[] args) {
        String str = "thgyfh";
        int L = 2;
        int R = 6;

        Map<Character, Integer> frequencyCount = new HashMap<>();

        for (int i = Math.min(L, R); i < Math.max(L, R); i++) {
            frequencyCount.merge(str.charAt(i), 1, Integer::sum);
        }
    }

}
