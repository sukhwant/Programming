package mission.red.interviewbit;

import java.util.ArrayList;

public class MergeSortedList {

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) > b.get(j)) {
                a.add(i, b.get(j));
                j++;
            }
            i++;
        }

        while (j < b.size()) {
            a.add(b.get(j));
            j++;
        }
    }


    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();
        a.add(-4);
        a.add(3);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(-2);
        b.add(-2);

        new MergeSortedList().merge(a, b);

        System.out.println(a);
    }
}
