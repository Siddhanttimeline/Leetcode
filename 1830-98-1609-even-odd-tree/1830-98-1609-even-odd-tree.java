class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int prev;

        while (!queue.isEmpty()) {
            int size = queue.size();
            prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 0) {
                    // even level
                    if (!(node.val % 2 != 0 && prev < node.val)) {
                        return false;
                    }

                } else if (level % 2 != 0) {
                    // odd level
                    if (!(node.val % 2 == 0 && node.val < prev)) {
                        return false;
                    }
                }

                prev = node.val;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            level++;
        }

        return true;
    }
}