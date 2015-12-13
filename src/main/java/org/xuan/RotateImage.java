package org.xuan;

/**
 * Created by xuan on 2015/12/12.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        for(int i = 0; i < matrix.length /2 ; i++) {
            rotate(matrix, i);
        }
    }

    private void rotate(int[][] matrix, int depth) {
        for(int i = depth; i < matrix.length - depth - 1; i++) {
            int temp = matrix[depth][i];
            matrix[depth][i] = matrix[matrix.length - i - 1][depth];
            matrix[matrix.length - i - 1][depth] = matrix[matrix.length - depth - 1][matrix.length - i - 1];
            matrix[matrix.length - depth - 1][matrix.length - i - 1] =  matrix[i][matrix.length - depth - 1] ;
            matrix[i][matrix.length - depth - 1] = temp;
        }
    }
}
