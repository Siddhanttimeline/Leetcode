class Solution {
    int totalMoves;

    public int distributeCoins(TreeNode root) {
        totalMoves = 0;
        dfs(root);
        return totalMoves;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftExcess = dfs(root.left);
        int rightExcess = dfs(root.right);

        totalMoves += Math.abs(leftExcess) + Math.abs(rightExcess);

        return root.val + leftExcess + rightExcess - 1;
    }
}