package org.openmetadata.service.formatter.decorators;

import java.util.ArrayList;
import java.util.List;

/**
 * MinHeap implementation using an ArrayList
 * - insert (heapifyUp)
 * - delete (heapifyDown)
 * - peek min without delete
 */
public class MinHeap<T extends Comparable<T>> {
    private List<T> minHeap;

    public MinHeap() {
        minHeap = new ArrayList<>();
    }

    private void swap(int i, int j) {
        T temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }

    public void offer(T value) {
        minHeap.add(value);
        heapifyUp(minHeap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (minHeap.get(index).compareTo(minHeap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public T poll() {
        if (minHeap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = minHeap.get(0);
        swap(0, minHeap.size() - 1);
        minHeap.remove(minHeap.size() - 1);
        if (!minHeap.isEmpty()) {
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyDown(int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            int smallest = index;

            if (leftIndex < minHeap.size() && minHeap.get(leftIndex).compareTo(minHeap.get(smallest)) < 0) {
                smallest = leftIndex;
            }

            if (rightIndex < minHeap.size() && minHeap.get(rightIndex).compareTo(minHeap.get(smallest)) < 0) {
                smallest = rightIndex;
            }

            if (index == smallest) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    public T peekMin() {
        if (minHeap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return minHeap.get(0);
    }

}
