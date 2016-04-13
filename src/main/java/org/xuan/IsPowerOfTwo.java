package org.xuan;

/**
 * Created by xzhou2 on 4/12/16.
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while(n >= 1) {
            if ((n & 1) > 0 ) {
                return n == 1;
            }
            n = n >>>1;
        }
        return false;
    }
}
