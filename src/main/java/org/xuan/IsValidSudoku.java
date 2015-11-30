package org.xuan;

/**
 * Created by xuan on 2015/11/29.
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidColumn(board) && isValidCell(board);
    }

    private boolean isValidRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] found = new boolean[9];
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                } else {
                    if (found[c - '0' - 1]) {
                        return false;
                    }
                    found[c - '0' - 1] = true;
                }
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] found = new boolean[9];
            for (int j = 0; j < board[0].length; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                } else {
                    if (found[c - '0' - 1]) {
                        return false;
                    }
                    found[c - '0' - 1] = true;
                }

            }
        }
        return true;
    }

    private boolean isValidCell(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] found = new boolean[9];
            for (int j = 0; j < board[0].length; j++) {


                char c = board[findRowNumber(i, j)][findColNumber(i, j)];
                if (c == '.') {
                    continue;
                } else {
                    if (found[c - '0' - 1]) {
                        return false;
                    }
                    found[c - '0' - 1] = true;
                }
            }
        }
        return true;
    }

    private int findRowNumber(int i, int j) {
        return i / 3 * 3 + j / 3;
    }

    private int findColNumber(int i, int j) {
        return i % 3 * 3 + j % 3;
    }
}
