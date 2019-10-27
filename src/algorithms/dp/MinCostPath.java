package algorithms.dp;

public class MinCostPath {
    public static void main(String[] args) {
        int[][] cost = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };

        System.out.println(minCost(cost, 2, 1));
        System.out.println(minCost(cost, 1, 2));
    }

    private static int minCost(int[][] cost, int m, int n) {
        int[][] res = new int[cost.length][cost[0].length];
        res[0][0] = cost[0][0];
        for (int col = 1; col < cost[0].length; col++) {
            res[0][col] = res[0][col - 1] + cost[0][col];
        }
        for (int row = 1; row < cost.length; row++) {
            res[row][0] = res[row - 1][0] + cost[row][0];
        }
        for (int row = 1; row < cost.length; row++) {
            for (int col = 1; col < cost[0].length; col++) {
                res[row][col] = min(res[row][col- 1], res[row - 1][col - 1], res[row - 1][col]) + cost[row][col];
            }
        }
        return res[m][n];
    }

    private static int min(int x, int y, int z) {
        return x < y ? (x < z ? x : z) : (y > z ? z : y);
    }
}
