package javatutorial.algorithms.sorting;

public class InsertionSort {

    private static void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int current = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > current) {
                input[j + 1] = input[j];
                j--;
            }

            // place current at j's location
            input[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 4, 3, 1, 5 };
        InsertionSort.sort(input);
        SortingUtil.print(input);
    }

}
