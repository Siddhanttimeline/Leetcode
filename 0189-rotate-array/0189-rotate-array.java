class Solution {
    public void rotate(int[] nums, int k) {   
        int n = nums.length;
        k %= n;
        int[] temp = new int[n];
        int p = 0;

        for(int i = n-k; i < n; i++){
            temp[p] = nums[i];
            p++;
        }

        for(int i=0; i < n-k; i++){
            temp[p] = nums[i];
            p++;
        }

        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }


    }
}