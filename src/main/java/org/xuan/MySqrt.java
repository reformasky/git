package org.xuan;

/**
 * Created by xuan on 2015/12/18.
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        return mySqrt(1, x, x);
    }

    private int mySqrt(int low, int high, int x) {
        if (high < low) {
            return high;
        }
        int mid = (low + high) /2;
        int q = x / mid;
        if (mid < q) {
            return mySqrt(mid + 1, high, x);
        }
        else if (mid == q) {
            return mid;
        }
        else {
            return mySqrt(low, mid - 1 , x);
        }
    }
}
