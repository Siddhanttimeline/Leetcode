class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        construct(root, str);
        return str.toString().substring(1, str.length() - 1);
    }

    private void construct(TreeNode node, StringBuilder str) {
        if (node == null)
            return;

        str.append("(").append(node.val);
        if (node.left == null && node.right != null) {
            str.append("()");
        }

        construct(node.left, str);
        construct(node.right, str);

        str.append(")");
    }

}