package org.openmetadata.service.formatter.decorators;

import java.util.ArrayList;
import java.util.List;


/**
 * MaxHeap implementation using an ArrayList
 * - insert (heapifyUp)
 * - delete (heapifyDown)
 * - peek max without delete
 */
public class MaxHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public void offer(T value) {
        heap.add(value);
        heapifyUp(size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public T poll() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T max = heap.get(0);
        swap(0, size() - 1);
        heap.remove(size() - 1);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return max;
    }

    private void heapifyDown(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;

            if (leftChildIndex < size() && heap.get(leftChildIndex).compareTo(heap.get(largest)) > 0) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < size() && heap.get(rightChildIndex).compareTo(heap.get(largest)) > 0) {
                largest = rightChildIndex;
            }

            if (index == largest) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }


    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap.get(0);
    }


    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

