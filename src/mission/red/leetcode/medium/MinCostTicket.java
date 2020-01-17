package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinCostTicket {

    Integer[] result = new Integer[366];
    Set<Integer> days;
    int maxDay;

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        System.out.println(new MinCostTicket().mincostTickets(days, costs));
    }

    public int mincostTickets(int[] day, int[] costs) {
        days = Arrays.stream(day).boxed().collect(Collectors.toSet());
        maxDay = day[day.length - 1];
        for (int i = day.length - 1; i >= 0; i--) {
            int currDay = day[i];
            result[currDay] = Math.min(Math.min(getResult(currDay + 1) + costs[0],
                getResult(currDay + 7) + costs[1]), getResult(currDay + 30) + costs[2]);
        }
        return result[day[0]];
    }

    private int getResult(int i) {
        while (!days.contains(i) && i < maxDay) {
            i++;
        }
        if (i > maxDay) {
            return 0;
        }
        return result[i];
    }
}
