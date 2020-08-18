package mission.red.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<String>();

        if(nums.length == 0){
            return result;
        }
        int currStart = 0;
        int currEnd = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[currEnd] + 1){
                currEnd++;
            } else{
                // found one....
                if(currStart != currEnd)
                    result.add("" + nums[currStart] + "->" + nums[currEnd]);
                else
                    result.add("" + nums[currStart]);
                currStart = i;
                currEnd = i;
            }
        }
        if(currStart != currEnd)
            result.add("" + nums[currStart] + "->" + nums[currEnd]);
        else
            result.add("" + nums[currStart]);
        return result;
    }

    public static void main(String[] args) {
        int[] input = {0,2,3,4,6,8,9};

        System.out.println(new SummaryRanges().summaryRanges(input));
    }
}
