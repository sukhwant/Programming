package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/dice-throw-dp-30/
 * 
 * @author sukhwanp
 *
 */
public class DiceThrow {

    public static int diceThrow(int n, int m, int x) {

        int[][] result = new int[n + 1][x + 1];

        // Base case n=1
        for (int i = 1; i <= m; i++) {
            result[1][i] = 1;
        }

        for (int dice = 2; dice <= n; dice++) {
            for (int sum = 1; sum <= x; sum++) {
                for (int faceValue = 1; faceValue <= m && faceValue < sum; faceValue++) {
                    result[dice][sum] += result[dice - 1][sum - faceValue];
                }
            }
        }
        return result[n][x];
    }

    public static void main(String[] args) {
        System.out.println(diceThrow(6, 3, 8));
    }

}
