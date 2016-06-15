package org.xuan;

import java.util.Arrays;

/**
 * Created by xzhou2 on 6/12/16.
 */
public class RussianDollEvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length < 2) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, (p, q) -> (p[0] != q[0] ? (p[0] - q[0]) : (p[1] - q[1])));
        int[] y = new int[envelopes.length];
        Arrays.fill(y, Integer.MAX_VALUE);
        int index = -1;
        for(int i = 0; i < envelopes.length;) {
            int begin = i;
            while(i < envelopes.length && envelopes[i][0] == envelopes[begin][0]){
                i++;
            };
            int[] pos = findIndexes(y, 0, index, envelopes, begin, i);
            for(int j = 0; j < pos.length; j++) {
                if (pos[j] == index+1) {
                    y[++index] = envelopes[j + begin][1];
                    break;
                }
                else  {
                    y[pos[j]] = Math.min(envelopes[j + begin][1], y[pos[j]]);
                }
            }
        }
        return index + 1;
    }

    private int[] findIndexes(int[] y, int low, int high, int[][] envs, int begin,int end) {
        int[] res = new int[end - begin];
        for(int i = begin; i < end; i++) {
            res[i - begin] = findIndex(y, low, high, envs[i][1]);
        }
        return res;
    }

    public int findIndex(int[] y, int low, int high, int val) {
        if (low >= high) {
            if (high < 0) {
                return 0;
            }
            return y[high] >= val ? high : high + 1;
        }
        int mid = low + (high - low) /2;
        if (y[mid] == val) {
            return mid;
        }
        else if (y[mid] < val) {
            return findIndex(y, mid +1, high, val);
        }
        else return findIndex(y, low, mid - 1, val);
    }

    public int maxEnvelopes_BETTER(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, (p, q) -> (p[0] != q[0] ? (p[0] - q[0]) : (q[1] - p[1])));
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }
}

