package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * @author sukhwanp
 *
 */
public class CoinChangeMaxPossibleWays {

    private static int coinChangeMaxWays(int[] coins, int n) {

        int[] table = new int[n + 1];

        Arrays.fill(table, 0);

        table[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = coins[j]; i <= n; i++) {
                table[i] += table[i - coins[j]];
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };

        System.out.println(coinChangeMaxWays(coins, 4));

    }

}
