package org.xuan;

/**
 * Created by xuan on 2015/12/20.
 */
public class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        return searchMatrix(matrix, target, 0, mapCordToIndex(new Cord(m-1, n -1), n));
    }

    private boolean searchMatrix(int[][] matrix, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) /2;
        Cord cord = mapIndexToCord(mid, matrix[0].length);
        if (matrix[cord.r][cord.c] == target) {
            return true;
        }
        else if (matrix[cord.r][cord.c] > target) {
            return searchMatrix(matrix, target, low, mid - 1);
        }
        else {
            return searchMatrix(matrix, target, mid + 1, high);
        }
    }



    private Cord mapIndexToCord(int index, int col) {
        int r = index / (col);
        int c = index % col;
        return new Cord(r, c);
    }

    private int mapCordToIndex(Cord cord, int col) {
        return cord.c + cord.r * col;
    }

    class Cord{
        int r;
        int c;
        Cord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
