package mission.red.leetcode.medium;

public class LongestPalindromicSubtring {

    public int longestPalindromicSubSequence(String input) {

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
        System.out.println(new LongestPalindromicSubtring().longestPalindromicSubSequence("babad"));
    }
}
