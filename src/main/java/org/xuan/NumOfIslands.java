package org.xuan;

/**
 * Created by xzhou2 on 4/11/16.
 */
public class NumOfIslands {
    public int numIslands(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return 0;
        }
        int nRow = board.length, nCol = board[0].length;
        int count = 0;
        boolean[][] visited = new boolean[nRow][nCol];
        for(int r = 0; r < nRow; r++) {
            for(int c = 0; c < nCol; c++) {
                if (!visited[r][c] && board[r][c] == '1') {
                    count++;
                    visit(board, visited, r, c);
                }
            }
        }
        return count;
    }

    private void visit(char[][] board, boolean[][] visited, int r, int c) {
        if (visited[r][c] || board[r][c] != '1') {
            return;
        }
        visited[r][c] = true;
        if (r > 0) {
            visit(board, visited, r - 1, c);
        }
        if (r < board.length - 1) {
            visit(board, visited, r + 1, c);
        }
        if (c > 0) {
            visit(board, visited, r, c - 1);
        }
        if (c < board[0].length - 1) {
            visit(board, visited, r ,c + 1);
        }
    }
}
