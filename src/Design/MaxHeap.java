package Design;

import java.util.Arrays;

public class MaxHeap {

    private int capacity;
    private int size;
    private int[] heap;

    public MaxHeap() {

        capacity = 10;
        size = 0;
        heap = new int[capacity];
    }

    public MaxHeap(int x) {

        capacity = x;
        size = 0;
        heap = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int peek() {

        if(isEmpty())
            throw new IllegalStateException("Empty heap");
        return heap[0];
    }

    public int remove() {

        if(isEmpty())
            throw new IllegalStateException("Empty heap");

        int max = heap[0];
        heap[0] = heap[size-1];
        size--;

        maxHeapifyDown();

        return max;
    }

    public void add(int x) {

        ensureExtraCapacity();

        heap[size] = x;
        size++;

        maxHeapifyUp();
    }

    private void ensureExtraCapacity() {
        if(size == capacity) {
            heap = Arrays.copyOf(heap,capacity*2);
            capacity *= 2;
        }
    }

    private void maxHeapifyUp() {

        int index = size - 1;

        while(hasParent(index) && parent(index) < heap[index]) {
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    private void maxHeapifyDown() {

        int index = 0;
        while(hasLeftChild(index)) {

            int biggerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChild(index))
                biggerChildIndex = getRightChildIndex(index);

            if(heap[index] > heap[biggerChildIndex])
                break;
            else
                swap(index,biggerChildIndex);

            index = biggerChildIndex;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    private int getLeftChildIndex(int index) { return 2 * index + 1; }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return heap[getParentIndex(index)];
    }

}
