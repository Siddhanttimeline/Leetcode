class Solution {
    Map<String, Integer> frequencyMap;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        frequencyMap = new HashMap<>();
        result = new ArrayList<>();
        serialize(root);
        return result;
    }

    private String serialize(TreeNode root) {
        if (root == null)
            return "null";

        String serialized = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        frequencyMap.put(serialized, frequencyMap.getOrDefault(serialized, 0) + 1);

        if (frequencyMap.get(serialized) == 2) {
            result.add(root);
        }

        return serialized;
    }
}