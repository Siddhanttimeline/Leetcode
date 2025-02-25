class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long left, long right) {
        if (root == null)
            return true;

        if (!(left < root.val && root.val < right)) {
            return false;
        }

        return validate(root.left, left, root.val) && validate(root.right, root.val, right);
    }
}