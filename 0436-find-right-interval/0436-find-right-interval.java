class Solution {
    public int[] findRightInterval(int[][] intervals) {

        TreeMap<Integer,Integer> startMap = new TreeMap<>();
        for(int i=0; i<intervals.length; i++){
            startMap.put(intervals[i][0],i);
        }

        int[] result = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            // Integer allows us to hold null values
            Integer nextStart = startMap.ceilingKey(intervals[i][1]);
            result[i] = (nextStart != null) ? startMap.get(nextStart) : -1;
        }

        return result;
    }
}



    // public int[] firstApproachUsingBinarySearch(int[][] intervals) {
    //     int[] result = new int[intervals.length];

    //     int[] starts = new int[intervals.length];
    //     for (int i = 0; i < intervals.length; i++) {
    //         starts[i] = intervals[i][0];
    //     }
    //     Arrays.sort(starts);

    //     for (int i = 0; i < intervals.length; i++) {
    //         int end = intervals[i][1];
    //         int getBSIndex = performOps(starts, end, intervals);
    //         result[i] = getBSIndex;
    //     }

    //     return result;
    // }

    // public int performOps(int[] starts, int target, int[][] intervals) {
    //     int index = Arrays.binarySearch(starts, target);

    //     if (index < 0) {
    //         index = -index - 1;
    //     }

    //     if (index < starts.length) {
    //         for (int i = 0; i < intervals.length; i++) {
    //             if (intervals[i][0] == starts[index]) {
    //                 return i;
    //             }
    //         }
    //     }
    //     return -1;
    // }
