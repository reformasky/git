package org.xuan;

/**
 * Created by xzhou2 on 5/26/16.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return n % 3 == 0 && isPowerOfThree(n/3);
    }
}
