class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serialize(root, result);
        return result.toString().substring(1, result.length() - 1);

    }

    private void serialize(TreeNode root, StringBuilder str) {
        if (root == null)
            return;

        str.append("(").append(root.val);

        if (root.left == null && root.right != null) {
            str.append("()");
        }

        if (root.left != null) {
            serialize(root.left, str);
        }

        if (root.right != null) {
            serialize(root.right, str);
        }

        str.append(")");
    }
}