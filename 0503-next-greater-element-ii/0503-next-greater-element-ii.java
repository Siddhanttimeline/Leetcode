class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                result[stack.pop()] = num;
            }
            // we will not push the indexes after n-1, 
            // as we only imagined them for the 
            // circular nature of the array and those are not required
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
}
