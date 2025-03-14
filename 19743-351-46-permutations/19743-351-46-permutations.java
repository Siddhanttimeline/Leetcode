class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, current, used, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, boolean[] used, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            current.add(nums[i]);
            backtrack(result, current, used, nums);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}