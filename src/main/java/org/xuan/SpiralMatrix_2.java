package org.xuan;

/**
 * Created by xuan on 2015/12/16.
 */
public class SpiralMatrix_2 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int begin = 1;
        for(int i = 0; i < n /2; i++) {
            begin = generateMatrix(i, result, begin);
        }
        if (n % 2 != 0) {
            result[n /2][n/2] = begin++;
        }
        return result;
    }

    private int generateMatrix(int d, int[][] matrix, int begin) {

        for(int i = d; i < matrix.length - d - 1; i++) {
            matrix[d][i] = begin++;
        }
        for(int i = d; i < matrix.length - d - 1; i++) {
            matrix[i][matrix.length - d - 1] = begin++;
        }
        for(int i = matrix.length - d - 1; i > d; i--) {
            matrix[matrix.length - d - 1][i] = begin++;
        }

        for(int i = matrix.length - d - 1; i > d; i--) {
            matrix[i][d] = begin++;
        }
        return begin;
    }
}
