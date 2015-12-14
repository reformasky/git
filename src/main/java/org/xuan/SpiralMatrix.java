package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/12/13.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        int m = matrix.length,
                n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        for(int i = 0; i < m/2 && i < n/2; i++) {
            spiralOrder(matrix, i, result);
        }
        if (m >= n && n % 2 != 0) {
            for(int d = n /2; d < m - n/2; d++) {
                result.add(matrix[d][n/2]);
            }
        }
        if (m < n && m % 2 != 0) {
            for(int d = m /2; d < n - m /2; d++) {
                result.add(matrix[m/2][d]);
            }
        }


        return result;
    }

    private void spiralOrder(int[][] matrix, int d, List<Integer> result) {
        int m = matrix.length,
                n = matrix[0].length;
        for(int i = d; i < n - d - 1; i++) {
            result.add(matrix[d][i]);
        }
        for(int i = d; i < m - d - 1; i++) {
            result.add(matrix[i][n - d - 1]);
        }
        for(int i = n - d - 1; i > d; i--) {
            result.add(matrix[m - d - 1][i]);
        }
        for(int i = m - d - 1; i > d; i--) {
            result.add(matrix[i][d]);
        }
    }
}
