package mission.red.interviewbit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LargestNUmber {

    public String largestNumber(final List<Integer> input) {

        String result = input.stream()
            .map(Object::toString)
            .sorted((o2, o1) -> o1.concat(o2).compareTo(o2.concat(o1)))
            .collect(Collectors.joining(""));
        return result.charAt(0) == '0'? "0" : result;

    }

    public static void main(String[] args) {
        System.out.println(new LargestNUmber().largestNumber(Arrays.asList(3, 30, 34, 5, 9)));

    }
}
