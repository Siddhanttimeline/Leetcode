package org.openmetadata.service.formatter.decorators;

import java.util.Arrays;

/**
 * Build the Max Heap (Heapify all non-leaf nodes)
 * Swap the Root (Largest Element) with the Last Element
 * Reduce the Heap Size and Heapify the Root
 * Repeat Until Sorted
 * **/
public class HeapSort {

    public void sort(int[] arr, boolean isAscending) {
        int size = arr.length;

        // Step 1: Build Heap (Max Heap for ascending, Min Heap for descending)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i, isAscending);
        }

        // Step 2: Extract elements one by one
        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i); // Move root to end
            heapify(arr, i, 0, isAscending); // Heapify the reduced heap
        }
    }

    private void heapify(int[] arr, int size, int index, boolean isAscending) {
        int extreme = index; // "extreme" refers to max or min depending on sort order
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // Choose largest (for ascending) or smallest (for descending)
        if (leftChildIndex < size && compare(arr[leftChildIndex], arr[extreme], isAscending)) {
            extreme = leftChildIndex;
        }
        if (rightChildIndex < size && compare(arr[rightChildIndex], arr[extreme], isAscending)) {
            extreme = rightChildIndex;
        }

        if (extreme != index) {
            swap(arr, index, extreme);
            heapify(arr, size, extreme, isAscending); // Recursive heapify
        }
    }

    private boolean compare(int a, int b, boolean isAscending) {
        return isAscending ? a > b : a < b;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        int[] arr1 = {4, 10, 3, 5, 1};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("Original array: " + Arrays.toString(arr1));

        sorter.sort(arr1, true);
        System.out.println("Sorted (Ascending): " + Arrays.toString(arr1));

        sorter.sort(arr2, false);
        System.out.println("Sorted (Descending): " + Arrays.toString(arr2));
    }
}
