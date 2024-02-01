
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];

            if( map.containsKey(sum%k) ){
                if(i - map.get(sum%k) > 1){
                    return true;
                }

            }else{
                map.put(sum%k,i);

            }

        }
        return false;
    }
}


// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
        
//         int sum=nums[0];
//         int i=0,j=1;

//         while( i < nums.length-1 ){

//             if(j == nums.length+1 ){
//                 i++;
//                 j=i+1;
//                 sum = nums[i];
//             }

//             if(j < nums.length){
//                 sum += nums[j];
//             }

//             if(sum % k == 0){
//                 return true;
//             }else{
//                 j++;
//             }
//         }

//         return false;

//     }
// }