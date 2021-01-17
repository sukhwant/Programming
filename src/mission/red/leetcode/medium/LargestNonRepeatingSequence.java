package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LargestNonRepeatingSequence {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> charCount = new HashMap<>();

        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!charCount.containsKey(c)){
                charCount.put(c, i);
            } else{
                maxLength = Math.max(maxLength, charCount.size());
                int pos = charCount.get(c);

                // Delete keys from map:
                for (int j = start; j <= pos; j++) {
                    charCount.remove(s.charAt(j));
                }
                charCount.put(c, i);

                start = pos + 1;
            }
        }
        return Math.max(maxLength, charCount.size());
    }

    public static void main(String[] args) {

        System.out.println(new LargestNonRepeatingSequence().lengthOfLongestSubstring("cdd"));
    }

}
