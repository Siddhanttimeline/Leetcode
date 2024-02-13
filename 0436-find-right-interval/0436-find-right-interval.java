class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];

        int[] starts = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
        }
        Arrays.sort(starts);

        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int getBSIndex = performOps(starts, end, intervals);
            result[i] = getBSIndex;
        }

        return result;
    }

    public int performOps(int[] starts, int target, int[][] intervals) {
        int index = Arrays.binarySearch(starts, target);

        if (index < 0) {
            index = -index - 1;
        }

        if (index < starts.length) {
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] == starts[index]) {
                    return i;
                }
            }
        }
        return -1;
    }
}
