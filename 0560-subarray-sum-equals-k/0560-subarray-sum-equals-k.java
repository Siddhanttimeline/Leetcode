class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for(int i=0; i<nums.length; i++){
            int j=i;
            int sum = 0;

            while(j<nums.length){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
                j++;
            }
        }

        return count;
    }
}