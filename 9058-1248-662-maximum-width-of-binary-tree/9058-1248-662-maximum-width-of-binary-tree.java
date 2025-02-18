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
    private int leftIndex;
    private int rightIndex;

    public int widthOfBinaryTree(TreeNode root) {
        max_width = Integer.MIN_VALUE;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            leftIndex = queue.peek().index;
            rightIndex = leftIndex;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                rightIndex = pair.index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * pair.index));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * pair.index + 1));
                }
            }

            max_width = Math.max(max_width, rightIndex - leftIndex + 1);
        }

        return max_width;
    }
}