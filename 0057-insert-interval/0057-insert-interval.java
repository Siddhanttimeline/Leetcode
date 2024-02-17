import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        boolean newIntervalAdded = false;

        for (int[] val : intervals) {
            if (!newIntervalAdded && val[0] > newInterval[0]) {
                merged.add(newInterval);
                newIntervalAdded = true;
            }
            merged.add(val);
        }

        if (!newIntervalAdded) {
            merged.add(newInterval); // Add newInterval if it wasn't added earlier
        }

        List<int[]> result = new ArrayList<>();

        for (int[] val : merged) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < val[0]) {
                result.add(val);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], val[1]);
            }
        }

        return result.toArray(new int[0][]);
    }
}
