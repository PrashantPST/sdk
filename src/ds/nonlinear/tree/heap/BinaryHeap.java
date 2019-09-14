package ds.nonlinear.tree.heap;

abstract class BinaryHeap {

    int[] heap;
    int heapSize;
    int capacity;

    BinaryHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        heapSize = 0;
    }

    int leftChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 1;
    }

    int rightChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 2;
    }

    int parentIndex(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }
}
