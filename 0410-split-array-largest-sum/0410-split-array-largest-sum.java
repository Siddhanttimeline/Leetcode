class Solution {
    public int splitArray(int[] nums, int k) {

        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int ans = high;

        while( low <= high ){
            int mid = low + (high-low)/2;
            int subArrays = getSubArraysCount(nums,mid);

            if(subArrays > k){
                low = mid + 1;
            }else{
                high = mid - 1;
                ans = Math.min(ans,mid);
            }
        }

        return ans;
    }

    public static int getSubArraysCount(int[] nums, int mid){
        int subArrays = 1;
        int tempSum = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] + tempSum <= mid){
                tempSum += nums[i];
            }else{
                subArrays++;
                tempSum = nums[i];
            }
        }
        return subArrays;
    }
}