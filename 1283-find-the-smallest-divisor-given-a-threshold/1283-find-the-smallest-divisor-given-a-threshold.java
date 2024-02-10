class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMaximum(nums);
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = getSum(nums, mid);

            if (sum <= threshold) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int getMaximum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            max = Math.max(max, val);
        }
        return max;
    }

    public static int getSum(int[] nums, int mid) {
        int sum = 0;

        for (int val : nums) {
            int num = (int) Math.ceil((double) val / mid);
            sum += num;
        }

        return sum;
    }
}
