package org.xuan;

/**
 * Created by xuan on 2015/11/29.
 */
public class LongestValidParenthesis {
    public int longestValidParentheses_1(String s) {
        if (s == null || "".equals(s)) return 0;
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - dp[i] >= 1 && s.charAt(i - dp[i] - 1) == '(') {
                dp[i + 1] = dp[i - dp[i] - 1] + dp[i] + 2;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public int longestValidParenthees(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int result = 0;
        int[] cache = new int[s.length() + 1];
        for(int i = 1; i <= s.length(); i++) {
            if (s.charAt(i) == ')') {
                int j = i - 2 - cache[i - 1];
                if (j >= 0 && s.charAt(j) == '(') {
                    cache[i] = cache[j] + cache[i-1] +2;
                    result = Math.max(result, cache[i]);
                }
            }
        }
        return result;
    }
}
