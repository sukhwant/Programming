package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
 * 
 * @author sukhwanp
 *
 */
public class LongestBitonicSequence {

    private static int longestBitonicSequence(int[] input) {

        int[][] result = new int[input.length][input.length];

        for (int i = 0; i < input.length - 1; i++) {
            result[i][i] = 0;
            result[i][i + 1] = 0;
        }
        result[input.length - 1][input.length - 1] = 0;

        for (int length = 3; length < input.length; length++) {
            for (int startIndex = 0; startIndex < input.length - length + 1; startIndex++) {

                int endIndex = startIndex + length - 1;

                if (input[startIndex] > input[startIndex + 1] && input[endIndex] < input[endIndex - 1]) {
                    result[startIndex][endIndex] = result[startIndex + 1][endIndex - 1] + 2;
                } else if (input[startIndex] > input[startIndex + 1]) {
                    result[startIndex][endIndex] = result[startIndex + 1][endIndex] + 1;
                } else if (input[endIndex] < input[endIndex - 1]) {
                    result[startIndex][endIndex] = result[startIndex][endIndex - 1] + 1;
                } else {
                    result[startIndex][endIndex] = result[startIndex + 1][endIndex - 1];
                }
            }
        }
        return result[0][input.length - 1];
    }

    public static void main(String[] args) {
        int[] input = {};
        System.out.println(longestBitonicSequence(input));
    }
}
