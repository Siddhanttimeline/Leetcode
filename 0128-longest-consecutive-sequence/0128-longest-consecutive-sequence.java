class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int max = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int val : nums){
            set.add(val);
        }

        for(int num : set){

            if(!set.contains(num-1)){
                int currNum = num;
                int count = 1;

                while(set.contains(currNum+1)){
                    currNum++;
                    count++;
                }

                max = Math.max(max,count);

            }
        }

        return max;



        // if(nums.length == 0){
        //     return 0;
        // }
        
        // Arrays.sort(nums);
        // int max = 1;
        // int count = 1;

        // for(int i=1; i<nums.length; i++){
        //     if(nums[i] != nums[i-1]){
        //         if(nums[i] == nums[i-1] + 1){
        //             count++;
        //             max = Math.max(max,count);
        //         }else{
        //             count = 1;
        //         }
        //     }
        // }

        // return max;

    }
}