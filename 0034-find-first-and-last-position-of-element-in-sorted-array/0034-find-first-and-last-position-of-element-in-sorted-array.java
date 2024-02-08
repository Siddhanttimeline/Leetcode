class Solution {
    public int[] searchRange(int[] nums, int target) {
        // return linearSearchApproach(nums, target);
        return binarySearch(nums, target);
    }

    public static int[] binarySearch(int[] nums, int target) {
        int lB = getLowerBound(nums, target);
        int uB = getUpperBound(nums, target);

        if (lB == nums.length || nums[lB] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{lB, uB - 1};   
        } 
    }

    public static int getUpperBound(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int getLowerBound(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] linearSearchApproach(int[] nums, int k) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        return new int[]{first, last};
    }
}
