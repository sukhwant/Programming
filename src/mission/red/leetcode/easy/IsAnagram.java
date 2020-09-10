package mission.red.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> countMap2 = new HashMap<>();

        if(s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            countMap.compute(s.charAt(i), (k, v) -> v == null ? 1: v + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            countMap2.compute(t.charAt(i), (k, v) -> v == null ? 1: v + 1);
        }

        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            if(!countMap2.containsKey(entry.getKey()) || !countMap2.get(entry.getKey()).equals(entry.getValue())){
                return false;
            }
        }
        for(Map.Entry<Character, Integer> entry: countMap2.entrySet()){
            if(!countMap.containsKey(entry.getKey()) || !countMap.get(entry.getKey()).equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new IsAnagram().isAnagram("rat","car"));
    }
}
