class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, current, result, target, candidates);
        return result;
    }

    private void backtrack(int index, List<Integer> current, List<List<Integer>> result, int target, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        current.add(candidates[index]);
        backtrack(index, current, result, target - candidates[index], candidates);
        current.remove(current.size() - 1);
        backtrack(index + 1, current, result, target, candidates);
    }
}