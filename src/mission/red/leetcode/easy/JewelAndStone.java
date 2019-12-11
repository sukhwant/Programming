package mission.red.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/jewels-and-stones
 */
public class JewelAndStone {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";

        System.out.println(new JewelAndStone().numJewelsInStones(J, S));
    }

    public int numJewelsInStones(String jewel, String stone) {
        int count = 0;
        Map<Character, Boolean> isJewel = new HashMap<>();
        for (int i = 0; i < jewel.length(); i++) {
            isJewel.put(jewel.charAt(i), true);
        }

        for (int i = 0; i < stone.length(); i++) {
            if(isJewel.containsKey(stone.charAt(i))){
                count++;
            }
        }
        return count;
    }

}
