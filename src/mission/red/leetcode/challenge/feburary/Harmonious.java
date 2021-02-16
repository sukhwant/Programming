package mission.red.leetcode.challenge.feburary;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Harmonious {

    public int findLHS(int[] nums) {

        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqCount.compute(nums[i], (k, v) -> (v == null) ? 1 : v + 1);
        }

        int max = 0;
        for (Entry<Integer, Integer> entry : freqCount.entrySet()) {
            if (freqCount.containsKey(entry.getKey() + 1)) {
                max = Math.max(max, entry.getValue() + freqCount.get(entry.getKey() + 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};

        System.out.println(new Harmonious().findLHS(nums));
    }

}
