class TaskInfo {
    int remainingExecutions;
    int nextAvailableTime;

    public TaskInfo(int remainingExecutions, int nextAvailableTime) {
        this.remainingExecutions = remainingExecutions;
        this.nextAvailableTime = nextAvailableTime;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int cooldownPeriod) {

        // Count the frequency of each task
        int[] taskFrequencies = new int[26];
        for (char task : tasks) {
            taskFrequencies[task - 'A']++;
        }

        // Max heap to process the most frequent tasks first
        PriorityQueue<Integer> taskMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int frequency : taskFrequencies) {
            if (frequency > 0) {
                taskMaxHeap.add(frequency);
            }
        }

        Queue<TaskInfo> cooldownQueue = new LinkedList<>();
        int totalTimeUnits = 0;

        while (!taskMaxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            totalTimeUnits++;

            if (!taskMaxHeap.isEmpty()) {
                int remainingExecutions = taskMaxHeap.poll() - 1;
                if (remainingExecutions > 0) {
                    cooldownQueue.add(new TaskInfo(remainingExecutions, totalTimeUnits + cooldownPeriod));
                }
            }

            // If a task has completed its cooldown, move it back to the max heap
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().nextAvailableTime == totalTimeUnits) {
                taskMaxHeap.add(cooldownQueue.poll().remainingExecutions);
            }
        }

        return totalTimeUnits;
    }
}
