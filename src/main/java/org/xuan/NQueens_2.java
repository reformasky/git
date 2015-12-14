package org.xuan;

/**
 * Created by xuan on 2015/12/13.
 */
public class NQueens_2 {
    int result = 0;
    public int solveNQueens(int n) {
        if (n == 0) {
            return result;
        }
        int[] cache = new int[n];
        solveNQueens(n, 0, cache);
        return result;
    }

    private void solveNQueens(int n, int index, int[] cache) {
        for(int i = 0; i < n; i++) {
            if (isValid(cache, i, index)) {
                cache[index] = i;
                if (index == n - 1) {
                    result++;
                }
                else {
                    solveNQueens(n, index + 1, cache);
                }
            }
        }
    }

    private boolean isValid(int[] current, int value, int index) {
        for(int i = 0; i < index; i++) {
            if (current[i] == value) {
                return false;
            }
            if (current[i]  - value == i - index || current[i] - value == - i + index ) {
                return false;
            }
        }
        return  true;
    }
}
