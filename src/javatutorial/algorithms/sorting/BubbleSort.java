package javatutorial.algorithms.sorting;

public class BubbleSort {

    public static void sort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    // swap
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 4, 3, 1, 5 };
        BubbleSort.sort(input);
        SortingUtil.print(input);
    }
}
