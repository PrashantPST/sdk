package ds.linear.arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Array {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 4, 3, 2 };
        System.out.println(minSwaps(arr));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if(nums1[p1] <= nums2[p2]) {
                nums1[index--] = nums2[p2--];
            }
            else {
                nums1[index--] = nums1[p1--];
            }
        }
        while(p2 >= 0) {
            nums1[index--] = nums2[p2--];
        }
    }

    private static int minSwaps(int[] arr) {

        int n = arr.length;

        List<Pair<Integer, Integer> > arrpos = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arrpos.add(new Pair<>(arr[i], i));

        arrpos.sort(Comparator.comparingInt(Pair::getKey));

        boolean[] visited = new boolean[n];

        int ans = 0;

        for(int i = 0; i < n; i++) {
            if (visited[i] || arrpos.get(i).getValue() == i)
                continue;

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arrpos.get(j).getValue();
                cycleSize++;
            }

            if(cycleSize > 0) {
                ans += (cycleSize - 1);
            }
        }
        return ans;
    }
}
