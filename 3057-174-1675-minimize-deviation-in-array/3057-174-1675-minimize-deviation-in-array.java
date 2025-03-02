class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int minVal = Integer.MAX_VALUE;
        int minDeviation = Integer.MAX_VALUE;

        for (int val : nums) {
            if (val % 2 != 0)
                val *= 2;

            minVal = Math.min(val, minVal);
            maxHeap.add(val);
        }

        while (!maxHeap.isEmpty()) {
            int maxVal = maxHeap.poll();
            minDeviation = Math.min(minDeviation, maxVal - minVal);

            if (maxVal % 2 != 0)
                break;

            maxVal = maxVal / 2;
            maxHeap.add(maxVal);

            minVal = Math.min(minVal, maxVal);
        }

        return minDeviation;
    }
}