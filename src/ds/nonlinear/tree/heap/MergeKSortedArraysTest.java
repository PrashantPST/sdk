package ds.nonlinear.tree.heap;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class MergeKSortedArraysTest {

    @Test
    public void mergeKSortedArraysTest() {

        int[][] input = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        int[] expectedOutput = { 1,2,3,4,5,6,7,8,9,10,11,12 };

        int[] output = MergeKSortedArrays.mergeKSortedArrays(input);

        System.out.println(Arrays.toString(output));
        assertEquals(Arrays.toString(expectedOutput), Arrays.toString(output));
    }

    @Test
    public void mergeKSortedArraysWithUnequalSizeTest() {

        int[][] input = {
                { 1, 2 },
                { 5, 6, 7},
                { 9, 10, 11, 12 }
        };

        int[] expectedOutput = { 1, 2, 5, 6, 7, 9, 10, 11, 12 };

        int [] output = MergeKSortedArrays.mergeKSortedArrays(input);

        System.out.println(Arrays.toString(output));
        assertEquals(Arrays.toString(expectedOutput), Arrays.toString(output));
    }
}
