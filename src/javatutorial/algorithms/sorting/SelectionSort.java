package javatutorial.algorithms.sorting;

public class SelectionSort {

    private static void sort(int[] input) {

        for (int i = 0; i < input.length; i++) {

            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }
            if (input[min] < input[i]) {
                // swap
                int temp = input[min];
                input[min] = input[i];
                input[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 4, 3, 1, 5 };
        SelectionSort.sort(input);
        SortingUtil.print(input);
    }

}
