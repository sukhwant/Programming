package javatutorial.algorithms.sorting;

public class MergeSort {

    public static void sort(int[] input) {
        mergeSort(input, 0, input.length - 1);
    }

    private static void mergeSort(int[] input, int start, int end) {
        if (end <= start) {
            return;
        } else {
            int mid = start + (end - start) / 2;

            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
            merge(input, start, end);
        }
    }

    private static void merge(int[] input, int start, int end) {
        int[] result = new int[end - start + 1];
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int resultIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (input[leftIndex] < input[rightIndex]) {
                result[resultIndex++] = input[leftIndex++];
            } else {
                result[resultIndex++] = input[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            result[resultIndex++] = input[leftIndex++];
        }

        while (rightIndex <= end) {
            result[resultIndex++] = input[rightIndex++];
        }

        // copy back
        int k = 0;
        for (int i = start; i <= end; i++) {
            input[i] = result[k++];
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 1, 3, 4, 5 };
        MergeSort.sort(input);
        SortingUtil.print(input);
    }

}
