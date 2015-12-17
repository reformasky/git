package org.xuan;

/**
 * Created by xuan on 2015/12/16.
 */
public class MinSumPath {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int[][] cache = new int[r][c];
        cache[0][0] = grid[0][0];
        for(int i = 1; i < c; i++) {
            cache[0][i] = cache[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < r; i++) {
            cache[i][0] = cache[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]) + grid[i][j];
            }
        }
        return cache[r - 1][c - 1];
    }
}
