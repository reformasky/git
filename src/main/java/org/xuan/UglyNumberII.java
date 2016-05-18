package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        List<Integer> cache = new ArrayList<>(n);
        cache.add(1);
        int[] multiplier = new int[] {2, 3, 5};

        int[] indexes = new int[]{0,0,0};

        while(cache.size() < n) {
            int min = Integer.MAX_VALUE;
            int[] mins = new int[3];
            for(int i = 0; i < 3; i++) {
                mins[i] = (cache.get(indexes[i]) * multiplier[i]);
                if (mins[i] < min) {
                    min = mins[i];
                }
            }
            cache.add(min);
            for(int i = 0; i < 3; i++) {
                if (mins[i] == min) {
                    indexes[i]++;
                }
            }
        }
        return cache.get(n-1);
    }
}
