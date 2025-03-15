class Solution {
    private int ROWS, COLMS;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLMS = board[0].length;
        visited = new boolean[ROWS][COLMS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLMS; c++) {
                if (dfs(r, c, board, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int column, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || column < 0 || row >= ROWS || column >= COLMS || visited[row][column]
                || word.charAt(index) != board[row][column]) {
            return false;
        }

        visited[row][column] = true;

        boolean result = dfs(row + 1, column, board, word, index + 1) || dfs(row - 1, column, board, word, index + 1)
                || dfs(row, column + 1, board, word, index + 1) || dfs(row, column - 1, board, word, index + 1);

        visited[row][column] = false;
        return result;
    }
}