class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int pointer = nums.length - 1;

        while (left <= right) {
            int leftS = nums[left] * nums[left];
            int rightS = nums[right] * nums[right];

            if (leftS < rightS) {
                result[pointer] = rightS;
                right--;
                pointer--;
            } else if (leftS >= rightS) {
                result[pointer] = leftS;
                left++;
                pointer--;
            }
        }

        return result;
    }
}
