package Design;

import java.util.Arrays;

public class MinHeap {

    private int capacity;
    private int size;
    private int[] heap;

    /**
     * Default constructor sets capacity to 10
     */
    public MinHeap() {

        capacity = 10;
        size = 0;
        heap = new int[capacity];
    }

    /**
     * Constructor
     */
    public MinHeap(int x) {

        capacity = x;
        size = 0;
        heap = new int[capacity];
    }

    /**
     * Checks if the heap is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the heap is full
     */
    public boolean isFull(int x) {
        return size == capacity;
    }

    /**
     * Returns the element on top of the minHeap
     */
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Empty heap");
        return heap[0];
    }

    /**
     * Removes the smallest element from the heap
     */
    public int remove() {

        if (isEmpty())
            throw new IllegalStateException("Empty heap");

        // Move the last item in the heap to index 0 to ensure that the tree remains complete
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        minHeapifyDown();

        return min;
    }

    /**
     * Adds an element to the heap
     */
    public void add(int x) {

        ensureExtraCapacity();

        heap[size] = x;
        size++;

        minHeapifyUp();
    }

    /**
     * Heap Restoration Helper Methods
     */

    /**
     * If heap is full, double capacity
     */
    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    private void minHeapifyUp() {

        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void minHeapifyDown() {

        int index = 0;

        while (hasLeftChild(index)) {

            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index))
                smallerChildIndex = getRightChildIndex(index);

            if (heap[index] < heap[smallerChildIndex])
                break;
            else
                swap(index, smallerChildIndex);

            index = smallerChildIndex;
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
