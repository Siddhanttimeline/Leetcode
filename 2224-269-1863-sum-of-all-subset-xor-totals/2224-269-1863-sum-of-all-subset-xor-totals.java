class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0, 0, nums);
    }

    private int dfs(int index, int total, int[] nums) {
        if (index == nums.length) {
            return total;
        }

        int include = dfs(index + 1, total ^ nums[index], nums);

        int exclude = dfs(index + 1, total, nums);

        return include + exclude;
    }
}
