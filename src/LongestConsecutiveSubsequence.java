package src;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestConsecutiveSubsequence(arr));
    }

    private static int findLongestConsecutiveSubsequence(int[] arr) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int item : arr) {
            set.add(item);
        }
        for (int value : arr) {
            if(!set.contains(value - 1)) {
                System.out.println("value = "+value);
                int count = 1;
                int j = value;
                while (set.contains(++j)) {
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
