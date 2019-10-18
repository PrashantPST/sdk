package ds.linear.arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static bits.BitArithmetic.testBitSet;

public class Array {

    private static final int INT_SIZE = 32;

    public static void main(String[] args) {

        int[] arr = new int[] { 2, 1, 12, 3, 2, 1, 5, 6, 7, 3, 7, 8, 9, 12, 34, 8, 6, 34 };
        System.out.println(Arrays.toString(findTwoUniqueNumbers(arr)));
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(arr)));
    }

    private static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }
        return productsOfAllIntsExceptAtIndex;
    }


    /**
     * Given an array in which all numbers except two are repeated once. (i.e. we have 2n+2 numbers and n numbers are occurring
     * twice and remaining two have occurred once). Find those two numbers in the most efficient way.
     */
    private static int[] findTwoUniqueNumbers(int[] arr) {
        int xOr = 0;
        int a = 0;
        int b = 0;
        int k = 0;
        for (int ar: arr) {
            xOr ^= ar;
        }
        while (!testBitSet(xOr, k)) {
            k++;
        }
        for (int e: arr) {
            if (testBitSet(e, k)) {
                a ^= e;
            }
            else {
                b ^= e;
            }
        }
        return new int[] { a, b};
    }

    /**
     * An array A with all elements occurring twice except for x that occur once.
     * Find the element x in O(1) space and O(N) time
     */
    private static int findUnique(int[] arr) {
        int x = 0;
        for (int value : arr) {
            x ^= value;
        }
        return x;
    }

    /**
     * Given an array where every element occurs three times, except one element which occurs only once.
     * Find that element that occurs once. Expected time complexity is O(n) and O(1) extra space.
     */
    private static int findUniqueNumber(int[] arr) {
        int result = 0;

        for(int i = 0; i < INT_SIZE; i++) {
            int sum = 0;
            for (int value : arr) {
                int val = (value & (1 << i));
                if (val != 0) {
                    sum += 1;
                }
            }
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
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
