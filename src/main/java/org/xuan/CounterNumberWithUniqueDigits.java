package org.xuan;

/**
 * Created by xzhou2 on 6/15/16.
 */
public class CounterNumberWithUniqueDigits {
    static int[] cache = new int[11];
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0) {
            cache[0] = 1;
            return 1;
        }
        if (n > 10) {
            return countNumbersWithUniqueDigits(10);
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        int pre =countNumbersWithUniqueDigits(n -1);
        int accu = 9, curr = 9;
        int t = n;
        while(--t > 0) {
            accu *= (curr--);
        }

        cache[n] = accu + pre;
        return cache[n];
    }
}
