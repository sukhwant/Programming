package mission.red.interviewbit;

import java.util.Arrays;
import java.util.List;

public class TripletSum {

    public int solve(List<String> A) {

        List<Double> input = A.stream().map(Double::valueOf).sorted().collect(java.util.stream.Collectors.toList());

        for (int i = 0; i < input.size(); i++) {
            double curr = input.get(i);
            int start = i + 1;
            int end = A.size() - 1;
            while (start < end) {
                if ((curr + input.get(start) + input.get(end)) > 2) {
                    end--;
                } else if ((curr + input.get(start) + input.get(end)) < 1) {
                    start++;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out
            .println(new TripletSum().solve(Arrays.asList("0.6", "0.7", "0.8", "1.2", "0.4")));
    }
}
