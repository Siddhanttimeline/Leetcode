class Solution {
    private int min_diff = Integer.MAX_VALUE;
    private Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        calculate(root);
        return min_diff;
    }

    private void calculate(TreeNode node) {
        if (node == null)
            return;

        calculate(node.left);
        if (prev != null)
            min_diff = Math.min(min_diff, node.val - prev);

        prev = node.val;
        calculate(node.right);
    }
}