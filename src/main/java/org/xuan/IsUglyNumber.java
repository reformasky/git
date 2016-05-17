package org.xuan;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class IsUglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        for(int i : new int[]{2,3,5}) {
            while(num % i == 0) {
                num = num /i;
            }
        }
        return num <= 1;
    }
}
