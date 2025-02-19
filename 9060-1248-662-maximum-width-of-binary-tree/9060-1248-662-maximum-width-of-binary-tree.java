class Pair {
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    private int max_width;
    private int left_index;
    private int right_index;

    public int widthOfBinaryTree(TreeNode root) {
        max_width = Integer.MIN_VALUE;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            left_index = queue.peek().index;
            right_index = left_index;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index;

                right_index = index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 1));
                }
            }

            max_width = Math.max(max_width, right_index - left_index + 1);
        }

        return max_width;
    }
}