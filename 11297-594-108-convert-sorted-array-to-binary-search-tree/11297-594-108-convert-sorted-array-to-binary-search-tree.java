class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] arr, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr[mid]); 

        node.left = build(arr, left, mid - 1); 
        node.right = build(arr, mid + 1, right);

        return node;
    }
}