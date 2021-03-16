package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class CountingTriagnles {

    public int nTriang(ArrayList<Integer> input) {

        Collections.sort(input);
        long sum = 0;
        for (int i = input.size() - 1; i > 1; i--) {

            int j = i - 1;
            int k = 0;

            while (k < j) {
                if (input.get(j) + input.get(k) <= input.get(i)) {
                    k++;
                } else {
                    sum += (j - k);
                    j--;
                }
            }
        }
        return (int)(sum % 1000000007);
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();

        input.add(1);
        input.add(1);
        input.add(1);
        input.add(2);
        input.add(2);

        System.out.println(new CountingTriagnles().nTriang(input));

    }
}
