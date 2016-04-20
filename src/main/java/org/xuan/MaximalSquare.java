package org.xuan;

/**
 * Created by xzhou2 on 4/19/16.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int nRow = matrix.length, nCol = matrix[0].length;
        int[][] size = new int[nRow][nCol];
        for(int r = 0; r < nRow; r++) {
            for(int c = 0; c < nCol; c++) {
                if (matrix[r][c] == '1') {
                    if (r == 0  || c== 0 ) {
                        size[r][c] = 1;
                    }
                    else {
                        size[r][c] = min(size[r-1][c-1], size[r-1][c], size[r][c-1]) + 1;

                    }
                    result = Math.max(result, size[r][c] * size[r][c]);
                }
            }
        }
        return result;
    }

    private int min(int a, int b, int c) {
        return a < b ? a < c ? a : c
                : b < c ? b : c;
    }
}
