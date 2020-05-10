class Solution {
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean crush = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // check horizontal line
                int v = Math.abs(board[i][j]);
                if (v == 0) continue;
                if (j + 2 < col && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    crush = true;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                }
                // check vertical line
                if (i + 2 < row && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    crush = true;
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                }
            }
        }
        // crush candy
        for (int j = 0; j < col; j++) {
            int index = row - 1;
            for (int i = row - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[index][j] = board[i][j];
                    index--;
                }
            }
            while (index >= 0) {
                board[index][j] = 0;
                index--;
            }
        }
        return crush ? candyCrush(board) : board;
    }
}
