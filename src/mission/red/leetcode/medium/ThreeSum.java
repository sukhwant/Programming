package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int currLeft = i+1;
            int currRight = nums.length - 1;
            int currRequired = -nums[i];
            while(currLeft< currRight){
                if(nums[currLeft] + nums[currRight] < currRequired){
                    currLeft++;
                } else if(nums[currLeft] + nums[currRight] > currRequired){
                    currRight--;
                } else{
                    //Found
                    res.add(Arrays.asList(nums[i], nums[currLeft], nums[currRight]));
                    currLeft++;
                    currRight--;
                }
            }
        }
        res = res.stream()
            .distinct()
            .collect(Collectors.toList());
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println( new ThreeSum().threeSum(nums));
    }
}
