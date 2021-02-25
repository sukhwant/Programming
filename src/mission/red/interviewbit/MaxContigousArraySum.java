package mission.red.interviewbit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxContigousArraySum {

    public int maxSubArray(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        boolean allNegative = true;

        for (Integer i : A) {
            if (i > 0) {
                allNegative = false;
            }
            maxEndingHere = maxEndingHere + i;

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }

            max = Math.max(max, maxEndingHere);
        }

        if(allNegative){
            return Collections.max(A);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxContigousArraySum().maxSubArray(Arrays.asList(-2)));
    }
}
