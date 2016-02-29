package org.xuan;

/**
 * Created by xuan on 2016/2/28.
 */
public class DistSubSequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() < t.length()) {
            return 0;
        }
        if (t.length() == 0) {
            return 1;
        }

        int[][] cache = new int[t.length()][s.length()];
        cache[0][0] = s.charAt(0) == t.charAt(0)? 1 : 0;
        for(int i = 1; i < s.length(); i++) {
            cache[0][i] = s.charAt(i) == t.charAt(0) ? cache[0][i-1] + 1 : cache[0][i-1];
        }

        for(int j = 1; j < t.length(); j++) {
            for(int i = 1; i < s.length(); i++) {
                cache[j][i] = s.charAt(i) == t.charAt(j) ? cache[j][i - 1] + cache[j-1][i-1] : cache[j][i-1];
            }
        }
        return cache[t.length() -1][s.length() -1];
    }
}
