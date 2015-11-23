package org.xuan;

/**
 * Created by xuan on 2015/11/19.
 */
public class StrStr_bf {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0
                || haystack.length() < needle.length() ) {
            return -1;
        }
        for(int i = 0; i <= haystack.length() - needle.length();i++) {
            if (isMatch(haystack, i, needle)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isMatch(String haystack, int startIndex, String needle) {
        for(int i = 0; i < needle.length(); i++, startIndex++) {
            if (startIndex >= haystack.length()) {
                return false;
            }
            if (haystack.charAt(startIndex) != needle.charAt(i) )
                return false;
        }
        return true;
    }
}
