package org.xuan;

/**
 * Created by xuan on 2015/11/11.
 */
public class PalindromicInt {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while(x / div >= 10) {
            div *= 10;
        }
        while(div > 0 ) {
            if (x %10 != x /div) {
                return false;
            }
            x %= div;
            x /= 10;
            div /= 100;
        }
        return true;
    }
}
