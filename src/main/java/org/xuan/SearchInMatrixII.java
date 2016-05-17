package org.xuan;

/**
 * Created by xzhou2 on 4/28/16.
 */
public class SearchInMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int r = 0; int j = matrix[0].length - 1;
        while(r < matrix.length && j >= 0) {
            int v = matrix[r][j];
            if (v == target) {
                return true;
            }
            if (v > target) {
                j--;
            }
            else {
                r++;
            }
        }
        return false;
    }
}
