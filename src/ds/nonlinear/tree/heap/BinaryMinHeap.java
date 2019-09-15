package ds.nonlinear.tree.heap;

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

    public static void main(String[] args) {
        BinaryMinHeap minHeap = new BinaryMinHeap(10);
    }
}
