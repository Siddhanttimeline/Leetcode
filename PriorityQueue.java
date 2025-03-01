package org.openmetadata.service.formatter.decorators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
    private final List<T> heap = new ArrayList<>();
    private final Comparator<T> comparator;

    // Default constructor: Creates a min-heap (natural ordering)
    public PriorityQueue() {
        this(Comparator.naturalOrder());
    }

    // Constructor with a comparator: Supports custom ordering (max-heap with reverseOrder)
    public PriorityQueue(Comparator<T> comparator) {
        this.comparator = (comparator != null) ? comparator : Comparator.naturalOrder();
    }

    public T peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public void offer(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (compare(heap.get(index), heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public T poll() {
        if (heap.isEmpty()) {
            return null;
        }
        T value = heap.get(0);

        int lastIndex = size() - 1;
        swap(0, lastIndex);
        heap.remove(lastIndex);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return value;
    }

    private void heapifyDown(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int target = index;

            if (leftChildIndex < size() && compare(heap.get(leftChildIndex), heap.get(target)) < 0) {
                target = leftChildIndex;
            }
            if (rightChildIndex < size() && compare(heap.get(rightChildIndex), heap.get(target)) < 0) {
                target = rightChildIndex;
            }
            if (index == target) {
                break;
            }
            swap(index, target);
            index = target;
        }
    }

    private int compare(T i, T j) {
        return comparator.compare(i, j);
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
