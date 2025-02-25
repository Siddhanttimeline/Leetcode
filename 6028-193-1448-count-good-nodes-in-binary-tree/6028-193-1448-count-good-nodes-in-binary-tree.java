class Solution {
    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }

    private int count(TreeNode root, int max) {
        if (root == null)
            return 0;

        max = Math.max(root.val, max);
        int goodNodes = root.val >= max ? 1 : 0;

        return goodNodes + count(root.left, max) + count(root.right, max);
    }
}