class Solution {
    public int findPairs(int[] nums, int k) {
        
        int pairs = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1;i++){
            int x = nums[i];
            int key = x+k;
            if(i==0 || nums[i-1] != nums[i]){
                int ans = Arrays.binarySearch(nums,i+1,nums.length,key);
                if(ans > 0){
                    pairs++;
                }
            }
        }

        return pairs;

        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int val : nums){
        //     map.put(val, map.getOrDefault(val,0)+1);
        // }

        // int pairs = 0;

        // for(int x : map.keySet()){

        //     if( (k > 0 && map.containsKey(x + k)) || (k == 0 && map.get(x) > 1)){
        //         pairs++;
        //     }
        // }

        // return pairs;
    }
}
