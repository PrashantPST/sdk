package ds.nonlinear.tree.heap;

public class BinaryMaxHeap extends BinaryHeap {

    private BinaryMaxHeap(int capacity) {
        super(capacity);
    }

    private void maxHeapify(int i, int heapSize) {
        int l = leftChildIndex(i);
        int r = rightChildIndex(i);
        int largest = i;
        if (l < heapSize && heap[l] > heap[i])
            largest = l;
        if (r < heapSize && heap[r] > heap[largest])
            largest = r;
        if (largest != i) {
            heap[i] = heap[largest] + heap[i] - (heap[largest] = heap[i]);
            maxHeapify(largest, heapSize);
        }
    }

    public void insert(int value) {
        if (heapSize == capacity) {
            return;
        }
        int i = heapSize;
        heap[i] = value;

        while (i != 0 && heap[i] > heap[parentIndex(i)]) {
            heap[i] = heap[parentIndex(i)] + heap[i] - (heap[parentIndex(i)] = heap[i]);
            i = parentIndex(i);
        }
        heapSize++;
    }

    void buildMaxHeap() {
        int startIdx = (heapSize - 2) / 2;

        for(int i = startIdx; i >= 0; i--) {
            maxHeapify(i, heapSize);
        }
    }

    public static void main(String[] args) {
        BinaryMaxHeap minHeap = new BinaryMaxHeap(10);
    }
}
