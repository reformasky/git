package org.xuan;

/**
 * Created by xuan on 2016/3/6.
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null ||s.length() == 0) {
            return true;
        }
        int low = 0, high = s.length() - 1;
        while(true) {
            while(low < high && !isCharacter(s.charAt(low))) {
                low++;
            }
            while(high > low && ! isCharacter(s.charAt(high))) {
                high--;
            }
            if (low < high) {
                if (toUpper(s.charAt(low++)) != toUpper(s.charAt(high--))) {
                    return false;
                }
            }else {
                break;
            }
        }
        return true;
    }

    private boolean isCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private char toUpper(char c) {
        if (c >= 'a') {
            return (char)(c - 'a' + 'A');
        }
        return c;
    }
}
