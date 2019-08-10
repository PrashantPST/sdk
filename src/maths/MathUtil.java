package maths;

public class MathUtil {

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
    public static long factorial(int n) {
        if(n <= 2)
            return n;
        long result = 1;
        int i = 1;
        while (++i <= n)
            result *= i;
        return result;
    }
}
