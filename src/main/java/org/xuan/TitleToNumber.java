package org.xuan;

/**
 * Created by xzhou2 on 4/1/16.
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            result = 26 * result + (c - 'A' + 1);
        }
        return result;
    }
}
