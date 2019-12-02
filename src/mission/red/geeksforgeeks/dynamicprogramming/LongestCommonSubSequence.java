package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * 
 * @author sukhwanp
 *
 */
public class LongestCommonSubSequence {

    public static int LCS(String str1, String str2) {

        int[][] ans = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {

                if (i == 0 || j == 0) {
                    ans[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                } else {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]);
                }
            }
        }
        return ans[str1.length()][str2.length()];
    }

    // TODO:- https://www.geeksforgeeks.org/printing-longest-common-subsequence/
    public static String LcsString(String str1, String str2) {

        int[][] ans = new int[str1.length() + 1][str2.length() + 1];

        int i = str1.length();
        int j = str2.length();
        char[] lcsString = new char[ans[str1.length()][str2.length()]];
        int k = lcsString.length;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcsString[k--] = str1.charAt(i);
            } else if (ans[i][j - 1] > ans[j][i - 1]) {
                j--;
            } else {
                i--;
            }
        }
        return new String(lcsString);
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        System.out.println(LCS(str1, str2));
        System.out.println(LcsString(str1, str2));

    }

}
