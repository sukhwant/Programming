package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedList {

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {

        ArrayList<Integer> merged = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < A.size() && j < B.size()) {

            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else{
                merged.add(A.get(i));
                i++;
                j++;
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        System.out.println(new IntersectionOfSortedList().intersect(Arrays.asList(1, 2, 3, 3,
            4, 5, 6),
            Arrays.asList(3, 3, 5)));
    }
}
