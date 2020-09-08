package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionArray {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        for (int j : nums1) {
            countMap.compute(j, (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (int j: nums2){
            if(countMap.containsKey(j) && countMap.get(j) > 0){
                countMap.compute(j, (k,v) -> v-1);
                result.add(j);
            }
        }

        return result.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(new IntersectionArray().intersect(nums1, nums2));
    }
}
