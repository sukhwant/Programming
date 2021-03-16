package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class ReadBook {

    public int books(ArrayList<Integer> input, int B) {

        int end = input.stream()
            .mapToInt(Integer::intValue)
            .sum();

        int start = Collections.max(input);
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(input, B, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private boolean isValid(final ArrayList<Integer> input, final int numberOfStudents,
        final int answer) {

        int students = 1;
        int sum = 0;

        for (int i = 0; i < input.size(); i++) {
            sum += input.get(i);

            if (sum > answer) {
                students++;
                sum = input.get(i);
            }

            if (students > numberOfStudents) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(12);
        input.add(34);
        input.add(67);
        input.add(90);

        System.out.println(new ReadBook().books(input, 2));
    }
}
