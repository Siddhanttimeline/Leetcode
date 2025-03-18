class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;

        int target = sum / 4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] sides = new int[4];
        return backtrack(matchsticks, sides, 0, target);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target)
                continue;

            sides[i] += matchsticks[index];

            if (backtrack(matchsticks, sides, index + 1, target))
                return true;

            sides[i] -= matchsticks[index];
        }

        return false;
    }

    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}