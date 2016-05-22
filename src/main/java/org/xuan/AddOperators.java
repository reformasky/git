package org.xuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 5/18/16.
 */
public class AddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        char[] copy = num.toCharArray();
        char[] path = new char[2 * copy.length];
        int val = 0;
        for(int i = 0; i < copy.length; i++) {
            val = val * 10 + copy[i] - '0';
            path[i] = copy[i];
            dfs(result, copy, target, 0, val, i+ 1, i+1, path);
            if (val == 0) {
                break;
            }
        }
        return result;
    }

    private void dfs(List<String> result, char[] copy, int target, long left, long curr, int index, int len, char[] path) {
        if (index == copy.length) {
            if (target == (left + curr)) {
                result.add(new String(path, 0, len));
            }
            return;
        }

        int j = len + 1;
        int val = 0;
        for(int i = index; i < copy.length;i++) {
            val = 10 * val + copy[i] - '0';
            path[j++] = copy[i];
            path[len] = '+';
            dfs(result, copy, target, left + curr, val, i + 1, j, path);
            path[len] = '-';
            dfs(result, copy, target, left + curr, -val, i + 1, j, path);
            path[len] = '*';
            dfs(result, copy, target, left, curr * val, i + 1, j, path);
            if(val == 0) {
                break;
            }

        }
    }

}
