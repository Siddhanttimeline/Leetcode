class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sum;
    }

    private void sum(TreeNode root, int num) {
        if (root == null)
            return;

        num = 10 * num + root.val;

        sum(root.left, num);

        if (root.left == null && root.right == null) {
            sum += num;
        }

        sum(root.right, num);
    }
}