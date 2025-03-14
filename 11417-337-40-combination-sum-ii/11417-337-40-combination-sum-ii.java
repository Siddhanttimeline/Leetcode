class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, current, result, target, candidates);
        return result;
    }

    private void backtrack(int index, List<Integer> current, List<List<Integer>> result, int target, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            if (target - candidates[i] >= 0) {
                current.add(candidates[i]);
                backtrack(i+1, current, result, target - candidates[i], candidates);
                current.remove(current.size() - 1);
            }
        }
    }
}