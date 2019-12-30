package mission.red.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch
 */
public class BinaryWatch {

    public static void main(String[] args) {
        System.out.println(new BinaryWatch().readBinaryWatch(1));
    }

    private void getTimeFromState(boolean[] states, List<String> results) {

        int hr = 0;
        for (int i = 0; i < 4; i++) {
            if (states[i]) {
                hr += 1 << i;
            }
        }
        int min = 0;
        for (int i = 4; i < 10; i++) {
            if (states[i]) {
                min += 1 << i - 4;
            }
        }
        if (hr < 12 && min < 60) {
            //System.out.println("String representation: " + hr + ":" + (min > 9 ? min : "0" +
            // min));
            results.add(hr + ":" + (min > 9 ? min : "0" + min));
        }
    }

    private void findSolution(boolean[] states, int num, int curr, List<String> result) {
        if (num == 0) {
            getTimeFromState(states, result);
            return;
        }
        for (int i = 0; i < states.length; i++) {
            if (!states[i]) {
                states[i] = true;
                findSolution(states, num - 1, i, result);
                states[i] = false; // Reset....
            }
        }
    }

    public List<String> readBinaryWatch(int num) {
        boolean[] states = new boolean[10];
        List<String> result = new ArrayList<>();
        findSolution(states, num, -1, result);
        return result;
    }
}
