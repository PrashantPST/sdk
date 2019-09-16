package ds.nonlinear.tree.heap;

import java.util.*;

public class BinaryMinHeap extends BinaryHeap {

    private BinaryMinHeap(int capacity) {
        super(capacity);
    }


    private void minHeapify(int i, int heapSize) {
        int l = leftChildIndex(i);
        int r = rightChildIndex(i);
        int smallest = i;

        if (l < heapSize && heap[l] < heap[i])
            smallest = l;
        if (r < heapSize && heap[r] < heap[smallest])
            smallest = r;
        if (smallest != i) {
            heap[i] = heap[smallest] + heap[i] - (heap[smallest] = heap[i]);
            minHeapify(smallest, heapSize);
        }
    }

    public void insert(int value) {
        if (heapSize == capacity) {
            return;
        }
        int i = heapSize;
        heap[i] = value;

        while (i != 0 && heap[i] < heap[parentIndex(i)]) {
            heap[i] = heap[parentIndex(i)] + heap[i] - (heap[parentIndex(i)] = heap[i]);
            i = parentIndex(i);
        }
        heapSize++;
    }

    private void buildMinHeap() {
        int startIdx = (heapSize - 2 ) / 2;

        for(int i = startIdx; i >= 0; i--) {
            minHeapify(i, heapSize);
        }
    }

    /**
     * @param nums
     * @param K
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a min heap
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));

        //maintain a heap of size k.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > K) {
                queue.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll().getKey());
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        BinaryMinHeap minHeap = new BinaryMinHeap(10);
    }
}
