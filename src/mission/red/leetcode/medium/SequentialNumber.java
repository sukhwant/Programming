package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialNumber {

    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new SequentialNumber().sequentialDigits(1000, 13000));
    }

    private void backtrack(int curr, int currDigit, int low, int high) {
        System.out.println(curr);
        if (curr > high || currDigit > 10) {
            return;
        }
        if (curr >= low) {
            System.out.println("Found..." + curr);
            result.add(curr);
        }

        backtrack(curr * 10 + currDigit, currDigit + 1, low, high);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        for (int i = 1; i <= 9; i++) {
            backtrack(0, i, low, high);
        }
        Collections.sort(result);
        return result;
    }
}
