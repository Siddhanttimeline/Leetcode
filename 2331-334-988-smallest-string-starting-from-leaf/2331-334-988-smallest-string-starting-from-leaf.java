class Solution {
    String smallestString = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallestString;
    }

    private void dfs(TreeNode root, StringBuilder str) {
        if (root == null)
            return;

        String valStr = String.valueOf((char) ('a' + root.val));
        str.append(valStr);

        dfs(root.left, str);

        if (root.left == null && root.right == null) {
            String newString = new StringBuilder(str).reverse().toString();
            if (newString.compareTo(smallestString) < 0) {
                smallestString = newString;
            }
        }

        dfs(root.right, str);
        str.deleteCharAt(str.length() - 1);
    }
}
