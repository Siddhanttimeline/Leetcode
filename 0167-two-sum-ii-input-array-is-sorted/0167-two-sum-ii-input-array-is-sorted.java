class Solution {
    public int[] twoSum(int[] numbers, int target) {


        int i=0;
        int j=numbers.length-1;
        int[] result = new int[2];

        while(i<j){
            int sum = numbers[i] + numbers[j];

            if(sum < target){
                i++;
            }else if(sum > target){
                j--;
            }else{
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
        }

        return result;


        // logic works but gives TLE 
        // int i=0, j=1;
        // int[] result = new int[2];

        // while(i < numbers.length-1){
            
        //     if(j==numbers.length){
        //         i++;
        //         j=i+1;
        //     }

        //     if(numbers[i] + numbers[j] == target){
        //         result[0] = i+1;
        //         result[1] = j+1;
        //         return result;
        //     }else{
        //         j++;
        //     }
        // }
        // return result;
    }
}