package ds.nonlinear.tree.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 10, 11, 15},
                {2, 4, 9, 14},
                {5, 6, 8, 16},
                {3, 7, 12, 13},
        };
        System.out.println(Arrays.toString(mergeKSortedArrays(arr)));

    }

    /**
     * Space: O(NK) (Plus O(K) for the heap)
     * Time: O(NK log(K))
     */
    private static class HeapNode {
        int arrayNum;
        int index;
        int value;

        HeapNode(int arrayNum, int index, int value){
            this.arrayNum = arrayNum;
            this.index = index;
            this.value = value;
        }
    }

    static int[] mergeKSortedArrays(int[][] arrays) {

        if(arrays == null) return null;

        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(arrays.length, Comparator.comparingInt((HeapNode a) -> a.value));

        int size = 0;
        for (int[] array : arrays) {
            size += array.length;
        }
        int[] result = new int[size];

        for(int i = 0; i < arrays.length; i++) {
            minHeap.add(new HeapNode(i, 0, arrays[i][0]));
        }

        //Complexity O(n * k * log k)
        for(int i = 0; i < size; i++) {
            //Take the minimum value and put into result
            HeapNode node = minHeap.poll();

            if(node != null) {
                result[i] = node.value;
                if(node.index + 1 < arrays[node.arrayNum].length) {
                    //Complexity of O(log k)
                    minHeap.offer(new HeapNode(node.arrayNum, node.index + 1, arrays[node.arrayNum][node.index + 1]));
                }
            }
        }
        return result;
    }
}
