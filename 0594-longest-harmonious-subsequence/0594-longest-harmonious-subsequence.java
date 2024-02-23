class Solution {
    public int findLHS(int[] nums) {
        
        int ans = 0;
        int i=0,j=0;
        Arrays.sort(nums);

        while(i < nums.length && j < nums.length){

            if(nums[j] - nums[i] == 1){
                ans = Math.max(ans , j-i+1);
                j++;
            }else if( nums[j] - nums[i] == 0){
                j++;
            }else{
                i++;
            }

        }

        return ans;
    }
}