package algorithms.dp;

import java.util.Arrays;

/**
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
 * valued coins, what is the minimum number of coins to make the change?
 */
public class CoinChange {
    static private int[] coins = { 8, 3, 1, 2 };

    public static void main(String[] args) {
        int m = coins.length;
        int amount = 3;
        long[][] solution= new long[m+1][amount+1];
        for(long[] arr: solution) {
            Arrays.fill(arr, -1L);
        }
        System.out.println(getWays(m - 1, amount, solution));
    }

    private static long getWays(int coinIndex, int amount, long[][] solution) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (coinIndex < 0) {
            return 0;
        }
        if (solution[coinIndex][amount] == -1L) {
            solution[coinIndex][amount] = getWays(coinIndex - 1, amount, solution) +
                    getWays(coinIndex, amount - coins[coinIndex], solution);
        }
        return solution[coinIndex][amount];
    }
}