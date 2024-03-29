class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentFuel = 0;
        int start = 0;

        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();

        if (gasSum < costSum) {
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            currentFuel += gas[i] - cost[i];

            if (currentFuel < 0) {
                start = i + 1;
                currentFuel = 0;
            }
        }            

        return start;
    }
}
