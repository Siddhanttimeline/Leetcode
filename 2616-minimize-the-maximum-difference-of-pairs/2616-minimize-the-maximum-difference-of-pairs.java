class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1];
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossible = isPossible(nums, mid, p);

            if (isPossible) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; // Look for larger differences
            }
        }

        return ans;
    }

    public boolean isPossible(int[] arr, int maxDiff, int pairs) {
        int count = 0;
        int i = 0;

        while(i < arr.length - 1) {
            if(Math.abs(arr[i] - arr[i+1]) <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count >= pairs;
    }



}