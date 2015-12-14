package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/12/13.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        List<List<Integer>> temp = solveNQueens(n, n - 1);
        for(List<Integer> l : temp) {
            result.add(convert(l));
        }
        return result;
    }

    private List<List<Integer>> solveNQueens(int n, int currentIndex) {
        List<List<Integer>> result = new ArrayList<>();
        if (currentIndex == 0) {
            for(int i = 0; i < n; i++) {
                List<Integer> ele = new ArrayList<>(n);
                ele.add(i);
                result.add(ele);
            }
            return result;
        }


        List<List<Integer>> last = solveNQueens(n, currentIndex - 1);
        for (List<Integer> list : last) {
            for(int i = 0; i < n; i++) {
                if (isValid(list, i, currentIndex)) {
                    List<Integer> copy = new ArrayList(list);
                    copy.add(currentIndex, i);
                    result.add(copy);
                }
            }
        }
        return result;

    }

    private boolean isValid(List<Integer> current, int value, int index) {
        for(int i = 0; i < index; i++) {
            if (current.get(i) == value) {
                return false;
            }
            if (current.get(i)  - value == i - index || current.get(i) - value == - i + index ) {
                return false;
            }
        }
        return  true;
    }

    private List<String> convert(List<Integer> current) {
        List<String> result = new ArrayList<>(current.size());
        for(int i = 0; i < current.size(); i++) {
            char[] cache = new char[current.size()];
            for(int j = 0; j < current.size(); j++) {
                if (j == current.get(i)) {
                    cache[j] = 'Q';
                }
                else {
                    cache[j] = '.';
                }
            }
            result.add(new String(cache));
        }
        return result;
    }


    public List<List<String>> solveNQueens_1(int n) {

        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        int[] cache = new int[n];
        solveNQueens(n, 0, cache, result);
        return result;

    }

    private void solveNQueens(int n, int index, int[] cache, List<List<String>> result) {
        for(int i = 0; i < n; i++) {
            if (isValid(cache, i, index)) {
                cache[index] = i;
                if (index == n - 1) {
                    result.add(convert(cache));
                }
                else {
                    solveNQueens(n, index + 1, cache, result);
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

    private List<String> convert(int[] current) {
        List<String> result = new ArrayList<>(current.length);
        for(int i = 0; i < current.length; i++) {
            char[] cache = new char[current.length];
            for(int j = 0; j < current.length; j++) {
                if (j == current[i]) {
                    cache[j] = 'Q';
                }
                else {
                    cache[j] = '.';
                }
            }
            result.add(new String(cache));
        }
        return result;
    }
}
