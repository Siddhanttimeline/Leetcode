class Solution {
    Map<Integer, Integer> inorderIndexMap;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int left, int right) {
        if (left > right)
            return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inorderRootIndex = inorderIndexMap.get(rootVal);
        root.right = buildTree(inorder, postorder, inorderRootIndex + 1, right);
        root.left = buildTree(inorder, postorder, left, inorderRootIndex - 1);

        return root;
    }

}