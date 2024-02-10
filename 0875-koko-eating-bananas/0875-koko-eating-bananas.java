class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMaximum(piles);
        int ans = high;

        while( low <= high ){
            int mid = low + (high-low)/2;
            int totalHours = getTotalHours(piles,mid);

            if(totalHours <= h){
                ans = Math.min(ans, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int getMaximum(int[] nums){
        int maximum = 0;
        for(int val : nums){
            if( val > maximum) maximum = val;
        }
        return maximum;
    }

    public static int getTotalHours(int[] nums, int mid){
        int totalHours = 0;
        for(int val : nums){
            totalHours += Math.ceil((double)val/mid);
        }
        return totalHours;
    }


}