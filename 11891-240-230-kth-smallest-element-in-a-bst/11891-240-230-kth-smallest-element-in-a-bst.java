class Solution {
    private int result;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        counter(root);
        return result;
    }

    private void counter(TreeNode root) {
        if (root == null || count == 0)
            return;

        counter(root.left);

        count--;

        if (count == 0) {
            result = root.val;
            return;
        }

        counter(root.right);
    }
}