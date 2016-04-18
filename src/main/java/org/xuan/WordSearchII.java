package org.xuan;

import util.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 4/15/16.
 */
public class WordSearchII {
    TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        assert board != null && board.length != 0 && board[0] != null && board[0].length != 0;
        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0) {
            return result;
        }
        for(String w : words) {
            root.addString(w);
        }
        if (root.isEnd()) {
            result.add("");
        }
        int nRow = board.length;
        int nCol = board[0].length;

        boolean[][] visited = new boolean[nRow][nCol];
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                dfs(board, i, j, visited, root,new StringBuilder(), result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited,TrieNode node, StringBuilder sb, List<String> result) {
        TrieNode next = node.get(board[row][col]);
        if (next != null) {
            sb.append(board[row][col]);
            if (next.isEnd()) {
                result.add(sb.toString());
                next.setEnd(false);
            }

            int index = sb.length() - 1;
            visited[row][col] = true;
            if (row > 0 && !visited[row -1][col]) {
                dfs(board, row - 1, col, visited,next, sb, result);
            }
            if (row < board.length - 1 && !visited[row + 1][col]) {
                dfs(board, row + 1, col, visited, next, sb, result);
            }
            if (col > 0 && !visited[row][col - 1]) {
                dfs(board, row, col - 1, visited, next, sb, result);
            }
            if (col < board[0].length - 1 && !visited[row][col + 1]) {
                dfs(board, row, col + 1, visited, next, sb, result);
            }
            visited[row][col] = false;
            sb.deleteCharAt(index);

        }

    }


}
