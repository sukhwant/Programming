package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {

        int index = -1;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) < A.get(i + 1)) {
                index = i;
            }
        }
        if (index == -1) {
            Collections.reverse(A);
            return A;
        }
        //swap i and i+1;
        int temp = A.get(index);

        for (int i = A.size() - 1; i > index; i--) {
            if (A.get(i) > A.get(index)) {
                temp = A.get(i);
                A.set(i, A.get(index));
                A.set(index, temp);
                break;
            }
        }
        // reverse from index + 1 onwards
        int i = index + 1;
        int j = A.size() - 1;

        while (i < j) {
            temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
            i++;
            j--;
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList input = new ArrayList();
        input.add(1);
        input.add(20);
        input.add(30);
        input.add(15);

        System.out.println(new NextPermutation().nextPermutation(input));
    }
}
