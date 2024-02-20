class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        int ans = 0;

        Arrays.sort(nums);

        while(right < nums.length){

            sum += nums[right];

            while ((long) nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }

            ans = Math.max(ans,right-left+1);
            right++;
        }

        return ans;
    }
}