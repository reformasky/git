package org.xuan;

import java.util.Arrays;

/**
 * Created by xzhou2 on 5/18/16.
 */
public class PerfectSquare {
    public int numSquares(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        int index;
        for(int i = 1; (index = i * i) <= n; i++) {
            cache[index] = 1;
        }
        for(int i = 1; i <= n; i++) {

            for(int j = 1; (index= (i + j * j)) <= n;j++) {
                cache[index] = Math.min(cache[i] + 1, cache[index]);
            }
        }
        return cache[n];
    }
}
