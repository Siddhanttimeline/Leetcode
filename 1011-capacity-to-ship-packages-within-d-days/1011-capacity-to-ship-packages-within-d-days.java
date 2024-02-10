class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        long low = getMax(weights);
        long high = getSum(weights);
        long ans = Integer.MAX_VALUE;

        while( low <= high ){
            long mid = low + (high-low)/2;
            long daysRequired = getDays(weights,mid);

            if(daysRequired <= days){
                ans = Math.min(ans,mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return (int)ans;
    }

    public static long getDays(int[] nums, long capacity){
        long days = 1;
        long sum = 0;
        for(int val : nums){
            if( sum + val> capacity){
                days++;
                sum = val;
            }else{
                sum += val;
            }
        }
        return days;
    }


    public static long getMax(int[] weights){
        long maximum = Integer.MIN_VALUE;
        for(int val : weights){
            maximum = Math.max(maximum,val);
        }
        return maximum;
    }

    public static long getSum(int[] weights){
        long sum = 0;
        for(int val : weights){
            sum += val;
        }
        return sum;
    }
}