class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;

        int result = 0;
        for (int i = 1; i <= n; i++) {  // Consider each number as root
            result += numTrees(i - 1) * numTrees(n - i);
        }

        return result;
    }
}
