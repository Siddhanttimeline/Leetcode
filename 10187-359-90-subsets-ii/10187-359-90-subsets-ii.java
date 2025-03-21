class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, current, result, nums);
        return result;
    }

    private void backtrack(int index, List<Integer> current, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]);
            backtrack(i + 1, current, result, nums);
            current.remove(current.size() - 1);
        }
    }
}