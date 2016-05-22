package org.xuan;

/**
 * Created by xzhou2 on 5/20/16.
 */
public class LiveGame {
    int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};
    public void gameOfLife(int[][] board) {
        if ( board == null|| board.length == 0|| board[0] == null|| board[0].length == 0) {
            return;
        }
        int nRow = board.length, nCol = board[0].length;
        for(int r = 0; r < nRow; r++) {
            for(int c = 0; c < nCol; c++) {
                int count = lives(board, r, c);
                boolean isAlive = (board[r][c] & 1) == 1;
                if (isAlive) {
                    if (count == 2 || count == 3) {
                        board[r][c] |= 2;
                    }
                }
                else if(count == 3) {
                    board[r][c] |= 2;
                }
            }
        }

        for(int r = 0; r< nRow; r++) {
            for(int c = 0; c < nCol; c++) {
                board[r][c] = (board[r][c] >> 1);
            }
        }
    }

    int lives(int[][] board, int r, int c) {
        int count = 0;
        int nRow = board.length, nCol = board[0].length;
        for(int[] direction : directions) {
            int row = r + direction[0], col = c + direction[1];
            if (row < 0|| row > nRow - 1 || col < 0 || col > nCol-1 || (board[row][col] & 1) == 0 ) {
                continue;
            }
            count++;
        }
        return  count;
    }
}
