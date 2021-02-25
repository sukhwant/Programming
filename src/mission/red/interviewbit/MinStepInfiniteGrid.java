package mission.red.interviewbit;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
public class MinStepInfiniteGrid {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int steps = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            steps += Math.max(Math.abs(A.get(i) - A.get(i + 1)), Math.abs(B.get(i) - B.get(i + 1)));
        }
        return steps;
    }


    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(-7);
        A.add(-13);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(-5);
        System.out.println(new MinStepInfiniteGrid().coverPoints(A, B));
    }
}
