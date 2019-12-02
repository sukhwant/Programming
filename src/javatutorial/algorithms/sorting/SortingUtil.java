package javatutorial.algorithms.sorting;

import java.util.Arrays;

public final class SortingUtil {

    public static void print(int[] input) {
        Arrays.stream(input).forEach(System.out::println);
    }

    private SortingUtil() {

    }
}
