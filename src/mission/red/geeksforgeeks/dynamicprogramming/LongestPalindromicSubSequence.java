package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
 * 
 * @author sukhwanp
 *
 */

public class LongestPalindromicSubSequence {

    private static int longestPalindromicSubSequence(String input) {

        int[][] result = new int[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {
            result[i][i] = 1;
        }

        for (int length = 2; length <= input.length(); length++) {
            for (int startIndex = 0; startIndex < input.length() - length + 1; startIndex++) {
                int endIndex = startIndex + length - 1;
                if (input.charAt(startIndex) == input.charAt(endIndex)) {
                    result[startIndex][endIndex] = result[startIndex + 1][endIndex - 1] + 2;
                } else {
                    result[startIndex][endIndex] = Math.max(result[startIndex + 1][endIndex],
                            result[startIndex][endIndex - 1]);
                }

            }
        }
        return result[0][input.length() - 1];
    }

    public static void main(String[] args) {
        String input = "GEEKS FOR GEEKS";

        System.out.println(longestPalindromicSubSequence(input));
    }

}
