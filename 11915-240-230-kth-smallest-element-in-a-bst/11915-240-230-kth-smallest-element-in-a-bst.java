class Solution {
    int count;
    int num;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        findKthSmallest(root);
        return num;
    }

    private void findKthSmallest(TreeNode root) {
        if (root == null)
            return;

        findKthSmallest(root.left);

        count--;
        if (count == 0) {
            num = root.val;
            return;
        }

        findKthSmallest(root.right);
    }
}