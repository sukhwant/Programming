package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0) {
            int[][] temp = new int[0][];
            return temp;
        }

        List<int[]> result = new LinkedList<>();

        List<int[]> sortedInput = Arrays.stream(intervals)
            .sorted((x,y) -> x[1]-y[1])
            .collect(Collectors.toList());

        int currStart = sortedInput.get(0)[0];
        int currEnd = sortedInput.get(0)[1];
        for (int i = 1; i < sortedInput.size(); i++) {
            if(sortedInput.get(i)[0] <= currEnd){
                // merge
                currEnd = sortedInput.get(i)[1];
                currStart = Math.min(currStart,sortedInput.get(i)[0]);
            } else{
                // partition found...
                int[] temp = new int[2];
                temp[0] = currStart;
                temp[1] = currEnd;
                result.add(temp);

                currStart = sortedInput.get(i)[0];
                currEnd = sortedInput.get(i)[1];

            }
        }

        int[] temp = new int[2];
        temp[0] = currStart;
        temp[1] = currEnd;
        result.add(temp);

        int[][] finalresult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalresult[i] = result.get(i);
        }
        return finalresult;
    }

    public static void main(String[] args) {
        int[][] input ={{1,4},{0, 4}};

        new MergeIntervals().merge(input);
    }
}
