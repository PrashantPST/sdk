package src;

/*
 * Factorial should be calculated iteratively as recursion can be costly for large numbers.
 */
public class FastFactorial {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(factorial(n));
    }
    private static long factorial(int n) {
        if(n <= 2)
            return n;
        long result = 1;
        int i = 2;
        while (i <= n)
            result *= i++;
        return result;
    }
}
