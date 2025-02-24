class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        build(root, result);
        return result.toString().substring(1, result.length() - 1);
    }

    private void build(TreeNode root, StringBuilder str) {
        if (root == null)
            return;

        str.append("(").append(root.val);

        if (root.left == null && root.right != null) {
            str.append("()");
        }

        if (root.left != null) {
            build(root.left, str);
        }

        if (root.right != null) {
            build(root.right, str);
        }

        str.append(")");
    }
}