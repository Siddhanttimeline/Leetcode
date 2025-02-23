class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        /**
         * What is a valid binary tree?
         * 1. All nodes must be connected.
         * 2. No cycles.
         * 3. Only one root. (root -> node with no parent)
         */

        /**
         * Solution:
         * 1. Check if only one root is there.
         * 2. Traverse the tree and keep track of the visited nodes. If all are
         * connected, we will be able to visit n nodes.
         * 3. While traversing, check for the cycle.
         */

        int[] parentsCount = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1)
                parentsCount[leftChild[i]]++;
            if (rightChild[i] != -1)
                parentsCount[rightChild[i]]++;
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parentsCount[i] == 0) {
                if (root == -1)
                    root = i; // root found
                else
                    return false; // multiple roots found
            }
        }

        if (root == -1)
            return false; // no root found

        Set<Integer> visited = new HashSet<>();
        return dfs(root, leftChild, rightChild, visited) && visited.size() == n;
    }

    private boolean dfs(int root, int[] leftChild, int[] rightChild, Set<Integer> visited) {
        if (root == -1)
            return true; // connected
        if (!visited.add(root))
            return false; // cycle detected

        return dfs(leftChild[root], leftChild, rightChild, visited)
                && dfs(rightChild[root], leftChild, rightChild, visited);
    }
}