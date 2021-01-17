package mission.red.leetcode.medium;

import java.util.Arrays;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;

        int surplus = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            surplus = surplus  + diff;

            if(surplus < 0){
                index = -1;
                surplus = 0;
            } else if(index == -1){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] gas  = {3, 3, 4};
        int[] cost = {3, 4, 4};

        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
