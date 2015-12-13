package org.xuan;

/**
 * Created by xuan on 2015/12/9.
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        if (m * n == 0) {
            return 0;
        }
        int[][] cache = new int[m][n];
        for(int i = 0; i < m; i++) {
            cache[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            cache[0][i] = 1;
        }
        return uniquePaths(m, n, cache);
    }

    private int uniquePaths(int m, int n, int[][] cache) {
        if (cache[m - 1][n - 1] != 0) {
            return cache[m-1][n-1];
        }
        int result = uniquePaths(m -1, n, cache) + uniquePaths(m, n-1, cache);
        cache[m-1][n-1] = result;
        return result;
    }
}
