class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0;
        long high = (long)1e14;

        while( low <= high ){
            long mid = low + (high - low)/2;
            long possible = getF(ranks,mid,cars);
            if(possible < cars){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }

    public static long getF(int[] nums, long mid, int p){
        long requiredCars = 0;
        for(int val : nums){
            requiredCars += Math.sqrt(mid/val);
        }
        return requiredCars;
    }
}