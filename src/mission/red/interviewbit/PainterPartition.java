package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class PainterPartition {

    public int paint(int A, int B, ArrayList<Integer> C) {

        int min = Collections.max(C);
        if (A > C.size()) {
            return B * min;
        }
        long minTime = B * min;
        long maxTime = 1000000000;

        while (maxTime > minTime) {
            long mid = (maxTime + minTime) / 2;
            if (isPossible(A, B, C, mid)) {
                maxTime = mid;
            } else {
                minTime = mid + 1;
            }
        }
        return (int) (maxTime % 10000003);
    }

    private boolean isPossible(final int A, final int B, final ArrayList<Integer> C,
        final long currAns) {

        int counter = 1;
        int currSum = 0;
        for (int i = 0; i < C.size(); i++) {
            currSum += B * C.get(i);
            if (currSum > currAns) {
                currSum = B * C.get(i);
                counter++;
            }
        }
        return counter <= A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(640);
        input.add(435);
        input.add(647);
        input.add(352);
        input.add(8);
        input.add(90);
        input.add(960);
        input.add(329);
        input.add(859);

        System.out.println(new PainterPartition().paint(1, 1000000, input));
    }
}
