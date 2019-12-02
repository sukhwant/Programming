package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeMinimumCoinRequired {

    private static final int MAX = 10000;

    private static int coinChangeMinimum(int[] coins, int n) {

        int[] table = new int[n + 1];

        Arrays.fill(table, MAX);

        table[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < coins.length; j++) {
                table[i] = Math.min(table[i], 1 + ((i - coins[j] >= 0) ? table[i - coins[j]] : 0));
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };

        System.out.println(coinChangeMinimum(coins, 4));

    }
}
