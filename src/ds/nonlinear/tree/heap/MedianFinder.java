package ds.nonlinear.tree.heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * To find the median, you must first sort your set of integers in non-decreasing order.
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 */
class MedianFinder {

    public static void main(String[] args) {
        int[] a = new int[] { 12, 13, 34, 3, 34, 11, 12, 4 };
        double[] result = runningMedian(a);
        System.out.println(Arrays.toString(result));
    }

    private static double[] runningMedian(int[] a) {
        int n = a.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            insert(a[i], minHeap, maxHeap);
            rebalance(minHeap, maxHeap);
            res[i] = getMedian(minHeap, maxHeap);
        }
        return res;
    }

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    private static void insert(int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() == 0 || number <= maxHeap.peek()) {
            maxHeap.offer(number);
        }
        else {
            minHeap.offer(number);
        }
    }
    private static void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if ((minHeap.size() - maxHeap.size()) > 1) {
            maxHeap.offer(minHeap.poll());
        }
        else if ((maxHeap.size() - minHeap.size()) > 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        }
        return ((minHeap.peek() + maxHeap.peek()) / 2.0);
    }
}
