package mission.red.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/h-index
 */
public class HCitation {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(new HCitation().hIndex(citations));
    }

    public int hIndex(int[] citations) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        int maxCitation = 0;
        for (int i = 0; i < citations.length; i++) {
            List<Integer> currList = map.getOrDefault(citations[i], new LinkedList<>());
            currList.add(i);
            map.put(citations[i], currList);
            maxCitation = Math.max(citations[i], maxCitation);
        }

        int currSum = 0;
        int citation = 0;
        for (int i = maxCitation; i >= 0; i--) {
            int citationAbove = currSum;
            if (map.containsKey(i)) {
                citationAbove = currSum + map.get(i).size();
                currSum += map.get(i).size();
            }
            if (citationAbove >= i) {
                citation = i;
                break;
            }
        }
        return citation;
    }
}

