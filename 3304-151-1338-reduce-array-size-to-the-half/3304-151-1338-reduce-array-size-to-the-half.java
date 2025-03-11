class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int val : arr) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());

        int removed = 0;
        int count = 0;
        int size = arr.length / 2;

        while (removed < size) {
            removed += maxHeap.poll();
            count++;
        }

        return count;
    }
}