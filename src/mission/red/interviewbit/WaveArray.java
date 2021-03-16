package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

    public ArrayList<Integer> wave(ArrayList<Integer> A) {

        Collections.sort(A);

        for (int i = 0; i <= A.size() - 2; i = i + 2) {
            int temp = A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1, temp);
        }

        return A;
    }

    public static void main(String[] args) {
    }
}
