package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2015/12/19.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int m = word1.length(),
                n = word2.length();
        int[][] cache = new int[m][n];
        cache[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for(int i = 1; i < m; i++) {
            cache[i][0] = (( word1.charAt(i) == word2.charAt(0) && cache[i-1][0] == i) ? 0 : 1)
                    + cache[i-1][0];
        }
        for(int j = 1; j < n; j++) {
            cache[0][j] =((word1.charAt(0) == word2.charAt(j) && cache[0][j - 1] == j) ? 0 : 1)
                    + cache[0][j - 1];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                cache[i][j] = min(cache[i][j - 1] + 1, cache[i-1][j]+ 1, cache[i-1][j-1] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1));
            }
        }
        return cache[m - 1][n -1];
    }

    public int minDistance_2(String word1, String word2) {
        int[] pre = new int[word2.length() + 1];
        int[] curr = new int[word2.length() + 1];
        for(int i = 0; i < pre.length; i++) {
            pre[i] = i;
        }
        for(int i = 1; i <= word1.length(); i++) {
            curr[0] = i;
            for(int j = 1; j <= word2.length(); j++) {
                curr[j] = min(curr[j - 1] + 1, pre[j] + 1, pre[j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1));
            }
            pre = Arrays.copyOf(curr, curr.length);
        }
        return pre[pre.length - 1];
    }
    private int min(int v1, int v2, int v3) {
        return v1 < v2 ? (v1 < v3 ? v1 : v3)
                : (v2 < v3 ? v2 : v3);
    }
}
