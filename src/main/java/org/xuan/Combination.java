package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2015/12/21.
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        if(k == 0) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
            return result;
        }
        Integer[] cache = new Integer[k];
        dfs(n, 0,cache, result);
        return result;
    }

    private void dfs(int n, int index, Integer[] cache, List<List<Integer>> result) {
        if (index == 0) {
            for(int i = 1; i <= n; i++) {
                cache[index] = i;
                dfs(n, index+1, cache, result);
            }
        }
        else if (index == cache.length) {
            result.add(new ArrayList<Integer>(Arrays.asList(cache)));
        }
        else {
            for(int i = cache[index-1] + 1; i <=n; i++ ) {
                cache[index] = i;
                dfs(n, index+1, cache, result);
            }
        }
    }
}
