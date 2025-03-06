class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int val : amount) {
            if (val > 0) {
                maxHeap.add(val);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) {
                time += maxHeap.poll();
                break;
            }

            time++;

            int cup1 = maxHeap.poll();
            int cup2 = maxHeap.poll();

            cup1--;
            cup2--;

            if (cup1 > 0)
                maxHeap.add(cup1);
            if (cup2 > 0)
                maxHeap.add(cup2);
        }

        return time;
    }
}