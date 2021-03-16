package mission.red.interviewbit;

import java.util.ArrayList;

public class DiffK {


    public int diffPossible(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = 1;

        if (A.size() < 2) {
            return 0;
        }

        while (i < A.size() && j < A.size()) {

            if (i == j) {
                j++;
                continue;
            }
            if (A.get(j) - A.get(i) > B) {
                i++;
            } else if (A.get(j) - A.get(i) < B) {
                j++;
            } else {
                System.out.println(A.get(i) + " " + A.get(j));
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        System.out.println(new DiffK().diffPossible(input, 0));
    }
}
