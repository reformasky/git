package org.xuan;

/**
 * Created by xuan on 2015/11/11.
 */
public class InvertInt {
    public int reverse(int x) {
        int result = 0,
                m = 0,
                q = x;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            result =  -reverse(-x);
            return result;
        }

        while(q > 0) {
            m = q % 10;
            q /= 10;
            if (result * 10 / 10 == result) {
                result *= 10;
            }
            else {
                return 0;
            }
            if (Integer.MAX_VALUE - m >= result) {
                result += m;
            }
            else {
                return 0;
            }

        }
        return result;
    }
}
