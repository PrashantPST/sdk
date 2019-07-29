package src;

import java.util.Arrays;
import java.util.Stack;

/*
 * PS:=> Find maximum of minimum for every possible window size [1, N] of a given linear.array.
 */
public class SlidingWindowMinMax {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 4, 7, 6, 2, 1, 3, 4, 6, 8 };
        System.out.println("Original Array:= "+Arrays.toString(arr));
        printMaxOfMin(arr);
        System.out.println();
    }
    private static void printMaxOfMin(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();
            if (!s.empty())
                left[i] = s.peek();
            s.push(i);
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();
            if (!s.empty())
                right[i] = s.peek();
            s.push(i);
        }
        System.out.println("Left Smaller:=  "+Arrays.toString(left));
        System.out.println("Right Smaller:= "+Arrays.toString(right));
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(arr[i], ans[len]);
        }
        System.out.println("Ans:=" +Arrays.toString(ans));
        for (int i = n - 1; i >= 1; i--)
            ans[i] = Math.max(ans[i], ans[i + 1]);
        System.out.println("Resultant ans= "+Arrays.toString(Arrays.copyOfRange(ans, 1, ans.length)));
        System.out.println("Resultant ans= "+Arrays.toString(Arrays.stream(ans, 1, ans.length).toArray()));
    }
}
