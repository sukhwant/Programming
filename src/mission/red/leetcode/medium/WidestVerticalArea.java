package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WidestVerticalArea {

    public int maxWidthOfVerticalArea(int[][] points) {

        List<Integer> input = Arrays.stream(points)
            .sorted((x,y) -> x[0]-y[0])
            .map(x -> x[0])
            .collect(Collectors.toList());

        int max = 0;
        for (int i = 0; i < input.size() - 1; i++) {
            int temp = input.get(i+1) - input.get(i);
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
