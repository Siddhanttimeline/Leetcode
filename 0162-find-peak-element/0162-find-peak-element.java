class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0; 

        while (i < nums.length - 1) {
            if (i == 0 && nums[i] > nums[i + 1]) {
                return i;
            }
            if (i > 0 && nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
            i++;
        }

        return nums.length - 1;
    }
}
