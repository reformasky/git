package org.xuan;

/**
 * Created by xuan on 2015/11/24.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend ^ divisor) >>> 31 == 1;
        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            dividend += Math.abs(divisor);
            result += 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return result;
        }

        int digit = 0;
        dividend = Math.abs(dividend);
        divisor  = Math.abs(divisor);
        while(divisor <= (dividend >> 1)) {
            digit++;
            divisor <<= 1;
        }
        while(digit >=0) {
            if (divisor<= dividend) {
                result += 1 << digit;
                dividend -= divisor;
            }
            digit--;
            divisor >>= 1;
        }
        return isNeg ? - result : result;
    }
}
