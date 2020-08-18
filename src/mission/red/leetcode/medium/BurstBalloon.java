package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloon {

    public static class Balloon {
        public int start;
        public int end;

        public Balloon(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        List<Balloon> balloons = Arrays.stream(points)
            .map(x -> new Balloon(x[0], x[1]))
            .sorted(Comparator.comparingInt(x -> x.end))
            .collect(Collectors.toList());

        System.out.println(balloons);
        int count = 1;
        int prevEnd = balloons.get(0).end;
        for (int i = 1; i < balloons.size(); i++) {
            if (balloons.get(i).start > prevEnd) {
                count++;
                prevEnd = balloons.get(i).end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] input = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int ans = findMinArrowShots(input);
        System.out.println("Answer is: " + ans);
    }
}
