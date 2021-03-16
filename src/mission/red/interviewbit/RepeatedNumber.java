package mission.red.interviewbit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RepeatedNumber {

    public int repeatedNumber(final List<Integer> A) {

        Collections.sort(A);

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i).equals(A.get(i + 1))) {
                return A.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedNumber().repeatedNumber(Arrays.asList(1, 2, 3, 4, 4, 5)));
    }
}
