package src.maths;

public class nprAndncr {
    public static void main(String[] args) {
        int n = 5;
        int r = 2;
        System.out.println(n+"P"+r+" = "+nPr(n, r));
        System.out.println(n+"C"+r+" = "+nCr(n, r));
    }

    /*
     * The value of C(n, r) can be calculated in O(r) time and O(1) extra space.
     */
    private static long nCr(int n, int r) {
        int res = 1;
        if (r > n - r)
            r = n - r;
        for (int i = 0; i < r; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    /*
     * The value of P(n, r) calculated in O(r) time and O(1) extra space.
     */
    private static long nPr(int n, int r) {
        long res = 1;
        while(r-- > 0)
            res *= n--;
        return res;
    }
}
