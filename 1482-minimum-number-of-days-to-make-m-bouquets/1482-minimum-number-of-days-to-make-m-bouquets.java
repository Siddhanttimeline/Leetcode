class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        long numberOfFlowers = (long)m * k;
        if (bloomDay.length < numberOfFlowers) {
            return -1;
        }

        long low = 1;
        long high = getMaximum(bloomDay);
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long bouquets = getBouquests(bloomDay, mid, k);

            if (bouquets >= m) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    public static long getMaximum(int[] nums) {
        long max = Integer.MIN_VALUE;
        for (long val : nums) {
            max = Math.max(max, val);
        }
        return max;
    }

    public static long getBouquests(int[] nums, long mid, long k) {
        long bouquets = 0;
        long tempCount = 0;

        for (long val : nums) {
            if (val <= mid) {
                tempCount += 1;
                if (tempCount == k) {
                    bouquets += 1;
                    tempCount = 0;
                }
            } else {
                tempCount = 0;
            }
        }

        return bouquets;
    }
}
