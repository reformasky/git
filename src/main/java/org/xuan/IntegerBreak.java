package org.xuan;

/**
 * Created by xzhou2 on 5/27/16.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }
        return helper(n);
    }

    private int helper(int n) {
        if (n <= 4) {
            return n;
        }
        if (n % 3 == 0) {
            return 3 * helper(n -3);
        } else if ( n % 3 == 1) {
            return 4 * helper(n - 4);
        } else {
            return 2 * helper(n -2);
        }
    }
}
