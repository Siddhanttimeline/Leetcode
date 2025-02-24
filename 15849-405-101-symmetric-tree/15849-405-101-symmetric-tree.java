class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode rootA, TreeNode rootB){
        if(rootA == null && rootB == null) return true;
        if(rootA == null || rootB == null) return false;
        if(rootA.val != rootB.val) return false;

        return rootA.val == rootB.val && compare(rootA.left, rootB.right) && compare(rootA.right, rootB.left);
    }
}