package mission.red.geeksforgeeks.easy;

/**
 * https://www.geeksforgeeks.org/count-the-number-of-ways-to-traverse-a-matrix/
 * 
 * @author sukhwanp
 *
 */
public class NumbersOfWaysToTraversematrix {

    public static void main(String[] args) {
        int m = 4;
        int n = 5;

        int[][] arr = {};
        arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }

        System.out.println(arr[m - 1][n - 1]);
    }

}
