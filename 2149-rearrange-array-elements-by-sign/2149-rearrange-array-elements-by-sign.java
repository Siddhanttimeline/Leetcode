class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] result = new int[nums.length];
        int pIndex = 0;
        int nIndex = 1;
        for(int val : nums){
            if(val > 0){
                result[pIndex] = val;
                pIndex += 2;
            }else{
                result[nIndex] = val;
                nIndex += 2;
            }
        }

        return result;



        // int[] positiveNumbers = new int[nums.length / 2];
        // int[] negativeNumbers = new int[nums.length / 2];
        // int pPointer = 0;
        // int nPointer = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > 0) {
        //         positiveNumbers[pPointer++] = nums[i];
        //     } else {
        //         negativeNumbers[nPointer++] = nums[i];
        //     }
        // }

        // int i = 0, j = 0, p = 0;
        // int[] result = new int[nums.length];
        // while (i < positiveNumbers.length) {
        //     result[p] = positiveNumbers[i];
        //     p++;
        //     result[p] = negativeNumbers[j];
        //     i++;
        //     j++;
        //     p++;
        // }

        // return result;
    }
}
