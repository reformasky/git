package org.xuan;

/**
 * Created by xuan on 2015/11/9.
 */
public class LongestPalindromicSubString {
     private String expandAroundCenter(String s, int c1, int c2) {
        int l = c1, r = c2;
        int n = s.length();
        while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

    public String longestPalindrome_solution2(String s) {
        int n = s.length();
        if (n == 0) return "";
        String longest = s.substring(0, 1);  // a single char itself is a palindrome
        for (int i = 0; i < n-1; i++) {
            String p1 = expandAroundCenter(s, i, i);
            if (p1.length() > longest.length())
                longest = p1;

            String p2 = expandAroundCenter(s, i, i+1);
            if (p2.length() > longest.length())
                longest = p2;
        }
        return longest;
    }

    public String longestPalindrome_solution1(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int length = 1;
        int beginIndex = 0;
        int endIndex = 0;
        boolean[][] record = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            record[i][i] = true;
        }
        for(int i = 1; i < s.length(); i++) {
            record[i - 1][i] = (s.charAt(i) == s.charAt(i - 1));

        }
        for(int i = 1; i < s.length(); i++) {
            if (record[i-1][i]) {
                length = 2;
                beginIndex = i - 1;
                endIndex = i;
                break;
            }
        }

        int end;
        for(int diff = 2; diff < s.length(); diff++) {
            for(int begin = 0 ; begin < s.length() - diff; begin++) {
                end = begin + diff;
                record[begin][end] = (record[begin+1][end-1]) && (s.charAt(begin) == s.charAt(end));
                if(record[begin][end] && (end - begin + 1 > length)) {
                    length = end - begin + 1;
                    beginIndex = begin;
                    endIndex = end;
                }
            }
        }
        return s.substring(beginIndex, endIndex + 1);
    }
}
