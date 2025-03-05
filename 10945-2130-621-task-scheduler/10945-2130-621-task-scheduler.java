class TaskInfo {
    int remainingExecution;
    int nextAvailableTime;

    public TaskInfo(int remainingExecution, int nextAvailableTime) {
        this.remainingExecution = remainingExecution;
        this.nextAvailableTime = nextAvailableTime;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int val : map.values()) {
            maxHeap.add(val);
        }

        Queue<TaskInfo> cooldownQueue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int freqCount = maxHeap.poll() - 1;
                if (freqCount > 0) {
                    cooldownQueue.add(new TaskInfo(freqCount, time + n));
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().nextAvailableTime == time) {
                maxHeap.add(cooldownQueue.poll().remainingExecution);
            }
        }

        return time;
    }
}