public class Solution {
    public int findBestValue(int[] arr, int target) { 
        long low = 0;
        long high = Arrays.stream(arr).max().getAsInt();

        long result = low;
        long minDiff = Integer.MAX_VALUE;

        while( low <= high ){
            long mid = low + (high - low) / 2L;
            int[] modifiedArray = getArray(arr,mid);
            long sum = Arrays.stream(modifiedArray).sum();
            long diff = Math.abs(sum-target); 

            if (diff < minDiff || (diff == minDiff && mid < result)) {
                minDiff = diff;
                result = mid;
            }

            if(sum > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }

        return (int) result;
    }

    public static int[] getArray(int[] nums, long mid){
        int[] mArray = Arrays.copyOf(nums, nums.length);

        for(int i=0; i<nums.length; i++){
            if(nums[i] > mid){
                mArray[i] = (int) mid;
            }
        }
        return mArray;
    }
}
