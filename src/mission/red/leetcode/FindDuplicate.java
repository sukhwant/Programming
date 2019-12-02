package mission.red.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], true);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};

        System.out.println(new FindDuplicate().containsDuplicate(input));
    }

}
