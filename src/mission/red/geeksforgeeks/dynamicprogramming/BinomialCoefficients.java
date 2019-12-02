package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
 * 
 * @author sukhwanp
 *
 */
public class BinomialCoefficients {

    private static int binomialCoefficients(int n, int r) {

        int[][] table = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {

                if (j == 0 || j == i) {
                    table[i][j] = 1;
                } else {
                    table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
                }
            }
        }
        return table[n][r];
    }

    public static void main(String[] args) {
        System.out.println(binomialCoefficients(5, 2));
    }

}
