package org.xuan;

/**
 * Created by xuan on 2016/1/25.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] cache = new int[s.length()];
        cache[s.length() - 1] = validChar(s, s.length() - 1) ? 1 : 0;
        if (s.length() >= 2) {
            int count = 0;
            if (validChar(s, s.length() - 2)) {
                count += cache[s.length() -1];
            }
            if (validTwoGram(s, s.length() -2)) {
                count += 1;
            }
            cache[s.length() - 2] = count;
        }
        else {
            return cache[0];
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            char c = s.charAt(i);
            int count = 0;
            if (validChar(s, i)) {
                count += cache[i + 1];
            }
            if (validTwoGram(s, i)) {
                count += cache[i + 2];
            }
            cache[i] = count;
        }
        return cache[0];
    }

    private boolean validTwoGram(String s, int startIndex) {
        if (startIndex >= s.length() - 1) {
            throw new IllegalArgumentException("startIndex is too large");
        }
        return (s.substring(startIndex, startIndex +2).compareTo("26") <= 0)
                && (s.substring(startIndex, startIndex+2).compareTo("10")>= 0);
    }

    private boolean validChar(String s, int index) {
        return s.charAt(index) <= '9' && s.charAt(index) >= '1';
    }
}
