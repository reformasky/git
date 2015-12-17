package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/12/15.
 */
public class PermutationSeq {
    private static int[] cache = new int[9];
    static {
        cache[0] = 1;
        for(int i = 1; i <= 8; i++) {
            cache[i] = cache[i-1] * i;
        }
    }
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0 ; i--) {
            int f = cache[i];
            int r = list.get((k - 1) / f);
            list.remove(list.get((k -1)/f));
            k = (k - 1) % f + 1;
            sb.append(r);
        }
        return sb.toString();
    }

}
