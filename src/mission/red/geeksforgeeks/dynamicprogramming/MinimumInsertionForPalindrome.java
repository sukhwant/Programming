package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
 * 
 * @author sukhwanp
 *
 */
public class MinimumInsertionForPalindrome {

    public static int minimumInsertionRequired(String input) {
        int result[][] = new int[input.length()][input.length()];

        for (int length = 1; length < input.length(); length++) {
            for (int start = 0; start < input.length() - length; start++) {
                int end = start + length;

                if (start == end) {
                    result[start][end] = 1;
                } else if (input.charAt(start) == input.charAt(end)) {
                    result[start][end] = result[start + 1][end - 1];
                } else {
                    result[start][end] = Math.min(result[start + 1][end], result[start][end - 1]) + 1;
                }
            }
        }
        return result[0][input.length() - 1];
    }

    public static int minimumInsertionRequiredWithLCS(String input) {
        int lcs = LongestCommonSubSequence.LCS(input, new StringBuilder(input).reverse().toString());
        return input.length() - lcs;
    }

    public static void main(String[] args) {
        String input = "geeks";
        System.out.println(minimumInsertionRequired(input));
        System.out.println(minimumInsertionRequiredWithLCS(input));
    }

}
