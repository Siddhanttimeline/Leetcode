class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. add to the left side (max heap)
        maxHeap.add(num);

        // 2. move it to the right side to make sure our left side is always smaller than right as in the next step is the diff goes beyond 1 it will balance it.
        minHeap.add(maxHeap.poll());

        // 3. balance the heap so that size diff of 1 is maintained in order to find median in O(1)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
