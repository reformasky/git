package org.xuan;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xuan on 2016/3/20.
 */
public class SurrandingRegions {
    int nRow = 0, nCol = 0;
    public void solve(char[][] board) {
        if (board != null) {
            nRow = board.length;
        }
        if (nRow != 0 && board[0] != null) {
            nCol = board[0].length;
        }
        if (nRow * nCol == 0) {
            return;
        }
        boolean[] keep = new boolean[nRow * nCol];
        Queue<Integer> toBeProcessed = new ArrayDeque<>();
        for (int i = 0; i < nRow; i++) {
            if (board[i][0] == 'O') {
                toBeProcessed.add(getIndex(i, 0));
            }
            if (board[i][nCol - 1] == 'O') {
                toBeProcessed.add(getIndex(i, nCol - 1));
            }
        }
        for(int j = 0; j < nCol; j++) {
            if (board[0][j] == 'O') {
                toBeProcessed.add(getIndex(0, j));
            }
            if (board[nRow - 1][j] == 'O') {
                toBeProcessed.add(getIndex(nRow -1, j));
            }
        }

        while(!toBeProcessed.isEmpty()) {
            int curr = toBeProcessed.remove();
            if (keep[curr]) {
                continue;
            }
            int row = getRow(curr), col = getCol(curr);
            keep[curr] = true;
            if (row > 0 && board[row-1][col] == 'O' && !keep[curr - nCol]){
                toBeProcessed.add(curr - nCol);
            }
            if (row < nRow - 1 && board[row + 1][col] == 'O' && !keep[curr + nCol]) {
                toBeProcessed.add(curr + nCol);
            }
            if (col > 0 && board[row][col -1] == 'O' && !keep[curr -1]) {
                toBeProcessed.add(curr -1);
            }
            if (col < nCol -1 && board[row][col + 1] == 'O' && !keep[curr + 1]) {
                toBeProcessed.add(curr +1);
            }
        }

        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if (board[i][j] == 'O' && !keep[getIndex(i, j)]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private int getIndex(int r, int c) {
        return r * nCol + c;
    }

    private int getRow(int index) {
        return index /nCol;
    }

    private int getCol(int index) {
        return index % nCol;
    }
}
