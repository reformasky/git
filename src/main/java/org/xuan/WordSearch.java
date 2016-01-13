package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/12/22.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length,
                n = board[0].length;
        if (m == 0 || n == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = 0;
                    if (dfs(board, 1, word, i, j)) {
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int index, String word, int r, int c) {
        if (index == word.length()) {
            return true;
        }
        char character = word.charAt(index);
        if (r > 0) {
            if (board[r - 1][c] == character) {
                board[r-1][c] = 0;
                if (dfs(board, index + 1, word, r - 1, c)) {
                    return true;
                }
                board[r-1][c] = character;
            }
        }

        if (r < board.length - 1) {
            if (board[r + 1][c] == character) {
                board[r+1][c] = 0;
                if (dfs(board, index + 1, word, r + 1, c)) {
                    return true;
                }
                board[r+1][c] = character;
            }
        }

        if (c > 0) {
            if (board[r][c - 1] == character) {
                board[r][c - 1] = 0;
                if (dfs(board, index + 1, word, r, c - 1)) {
                    return true;
                }
                board[r][c - 1] = character;
            }
        }
        if (c < board[0].length - 1) {
            if (board[r][c + 1] == character) {
                board[r][c + 1] = 0;
                if (dfs(board, index + 1, word, r, c + 1)) {
                    return true;
                }
                board[r][c + 1] = character;
            }
        }
        return false;
    }
}
