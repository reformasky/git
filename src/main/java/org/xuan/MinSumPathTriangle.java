package org.xuan;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2016/3/2.
 */
public class MinSumPathTriangle {
    public int minimumTotal(List<List<Integer>> input) {
        if (input == null || input.size() == 0) {
            return 0;
        }
        if (input.size() == 1) {
            return input.get(0).get(0);
        }

        int[] cache = new int[input.size()];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = input.get(0).get(0);
        int previousValue;
        int currentValue;
        for(int i = 1; i < input.size(); i++) {
            List<Integer> currentList = input.get(i);
            previousValue = cache[0];
            cache[0] += currentList.get(0);
            for(int j = 1; j <= i; j++) {
                currentValue = previousValue < cache[j] ? previousValue + currentList.get(j) :
                        cache[j] + currentList.get(j);
                previousValue = cache[j];
                cache[j] = currentValue;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int value : cache) {
            if (value < result) {
                result = value;
            }
        }
        return result;
    }
}
