package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2015/12/16.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int[] temp = new int[digits.length + 1];
        int carryOver = 1;
        for(int i = digits.length; i >= 1; i--) {
            temp[i] = (digits[i - 1] + carryOver) % 10;
            carryOver = (digits[i - 1] + carryOver) / 10;
        }
        if (carryOver > 0) {
            temp[0] = carryOver;
            return temp;
        }
        else {
            return Arrays.copyOfRange(temp,1, digits.length + 1);
        }
    }
}
