package org.xuan;

/**
 * Created by xzhou2 on 4/25/16.
 */
public class NumOfOnes {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int curr = n;
        int result = 0;
        int base = 1;
        while(curr > 0) {
            int m = curr % 10;
            int q = curr / 10;
            if (m > 1) {
                result += (q + 1) * base;
            }
            else if (m == 1) {
                result += q * base + n % base + 1;
            }
            else {
                result += q * base;
            }
            base *= 10;
            curr = q;
        }
        return result;
    }
}
