package mission.red.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacter {


    public int firstUniqChar(String s) {

        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countMap.compute(s.charAt(i), (k, v) -> v == null ? 1: v + 1);
        }

        for (int i = 0; i <s.length(); i++) {
            if(countMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueCharacter().firstUniqChar("leetcode"));
    }
}
