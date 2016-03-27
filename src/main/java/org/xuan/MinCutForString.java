package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2016/3/23.
 */
public class MinCutForString {
    int length;
    byte[][] isPalindrome;
    int[][] cache;
    public int cacheHit = 0, cacheMiss = 0;
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        length = s.length();
        isPalindrome = new byte[length][length];
        cache = new int[length][length];
        for(int i = 0; i < length; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }

        return minCut(0, length -1, s);
    }

    private int minCut(int begin, int end, String s) {
        if (begin == end) {
            return 0;
        }
        if (cache[begin][end] < Integer.MAX_VALUE) {
            cacheHit++;
            return cache[begin][end];
        }
        int result = Integer.MAX_VALUE;
        if (isValid(begin, end, s)) {
            result = 0;
        }
        else {
            for(int i = begin; i < end; i++) {
                int left = minCut(begin, i, s);
                int right = minCut(i + 1, end, s);
                if (result > left + right + 1) {
                    result = left + right + 1;
                    if (result == 1) {
                        break;
                    }
                }
            }
        }
        cacheMiss++;
        cache[begin][end] = result;
        return result;
    }
    private boolean isValid(int begin, int end, String s) {
        if (isPalindrome[begin][end] > 0) {
            return true;
        }
        else if (isPalindrome[begin][end] < 0) {
            return false;
        }

        boolean result = (s.charAt(begin) == s.charAt(end)) && (begin >= end -2 || isValid(begin + 1, end -1, s));
        if (result) {
            isPalindrome[begin][end] = 1;
        }
        else {
            isPalindrome[begin][end] = -1;
        }
        return result;
    }
}
