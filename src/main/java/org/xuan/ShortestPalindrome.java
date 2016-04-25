package org.xuan;

/**
 * Created by xzhou2 on 4/24/16.
 */
public class ShortestPalindrome {
    private static int[] generateTable(String s) {
        //assume that s is not empty;
        int[] result = new int[s.length()];
        result[0] = 0;
        int index = 0;
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == s.charAt(index)) {
                result[i] = result[i - 1] + 1;
                index++;
            }
            else {
                index = result[i-1];
                while(index > 0 && c != s.charAt(index)) {
                    index = result[index - 1];
                }
                if (c == s.charAt(index)) {
                    index++;
                }
                result[i] = index;
            }
        }
        return result;
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String reversed = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = generateTable(reversed);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse() + s;
    }
}
