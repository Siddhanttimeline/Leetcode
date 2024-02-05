class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for (int val : nums) {
            totalSum += val;
        }

        int target = totalSum - x;
        int left = 0;
        int right = 0;
        int currSum = 0;
        int ans = -1;

        while( right < n){
            currSum += nums[right];

            while( left <= right &&  currSum > target ){
                currSum -= nums[left];
                left++;
            }

            if( currSum == target ){
                ans = Math.max(ans , right - left + 1);
            }

            right++;

        }

        return ans == -1 ? -1 : n - ans;

    }


    // O(n^2)
    // public int bruteForceFirstIntuition(int[] nums, int x) {
    //     int n = nums.length;
    //     int totalSum = 0;
    //     for (int val : nums) {
    //         totalSum += val;
    //     }

    //     if (x > totalSum) {
    //         return -1;
    //     }

    //     if (x == totalSum) {
    //         return n;
    //     }

    //     int[] prefixSum = new int[n + 1];
    //     for (int i = 1; i <= n; i++) {
    //         prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    //     }

    //     int[] postfixSum = new int[n + 1];
    //     for (int i = n - 1; i >= 0; i--) {
    //         postfixSum[i] = postfixSum[i + 1] + nums[i];
    //     }

    //     int minOPS = Integer.MAX_VALUE;

    //     for (int i = 0; i <= n; i++) {
    //         if (prefixSum[i] > x) {
    //             break;
    //         }

    //         for (int j = n; j >= 0; j--) {
    //             if (postfixSum[j] > x) {
    //                 break;
    //             }

    //             if (prefixSum[i] + postfixSum[j] == x) {
    //                 minOPS = Math.min(minOPS, i + (n - j));
    //             }
    //         }
    //     }

    //     return minOPS == Integer.MAX_VALUE ? -1 : minOPS;
    // }



}