package org.xuan;

/**
 * Created by xzhou2 on 4/4/16.
 */
public class NumberOfTrailingZeros {
    public int trailingZeroes(int n) {
        long result = 0;
        long curr = 5;
        while(curr <= n) {
            result +=  n / curr;
            curr *= 5;
        }
        return (int)result;
    }
}
