package org.xuan;

/**
 * Created by xzhou2 on 4/18/16.
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while((1 & num) != 1 && num > 0) {
            if((num & 2) != 0) {
                return false;
            }
            num = num >> 2;
        }
        return num == 1;
    }

    public boolean isPowerOfFourI(int num) {
        if (num <= 0) {
            return false;
        }
        int count = 0;
        while((1 & num) != 1 && num > 0) {
            count++;
            num = num >> 1;
        }
        return (count % 2 == 0) && num == 1;
    }
}
