package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 * 
 * @author sukhwanp
 *
 */
public class EditDistance {

    public static void main(String[] args) {

        String str1 = "gesek";
        String str2 = "geek";

        System.out.println(editDistance(str1, str2));
    }

    private static int editDistance(String str1, String str2) {

        int[][] ans = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {

                if (i == 0) {
                    ans[i][j] = j;
                } else if (j == 0) {
                    ans[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    ans[i][j] = ans[i - 1][j - 1];
                } else {
                    int cross = ans[i - 1][j - 1] + 1;
                    int top = ans[i - 1][j] + 1;
                    int left = ans[i][j - 1] + 1;
                    ans[i][j] = Math.min(cross, Math.min(top, left));
                }
            }
        }

        return ans[str1.length()][str2.length()];
    }

}
