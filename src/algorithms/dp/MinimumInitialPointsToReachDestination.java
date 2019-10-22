package algorithms.dp;

public class MinimumInitialPointsToReachDestination {
    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        minimumPoints(mat, row - 1, col - 1, res);
        System.out.println(res[0][0]);
    }

    private static void minimumPoints(int[][] mat, int r, int c, int[][] res) {

    }

    private static int helper(int val, int expected) {
        if (val >= 0) {
            return 1;
        }
        return expected - val;
    }
}
