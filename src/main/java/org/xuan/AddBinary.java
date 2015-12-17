package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2015/12/16.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int length = Math.max(a.length(), b.length());
        char[] temp = new char[length + 1];
        int carryOver = 0;
        int value_a, value_b;
        int i = 0;
        while(i < a.length() && i < b.length()) {
            value_a = a.charAt(a.length() - 1 - i) - '0';
            value_b = b.charAt(b.length() - 1 - i) - '0';
            temp[temp.length - 1 - i] = (char)((carryOver + value_a + value_b) % 2 + '0');
            carryOver = (carryOver + value_a + value_b) / 2;
            i++;
        }
        while(i < a.length()) {
            value_a = a.charAt(a.length() - 1 - i) - '0';
            temp[temp.length - 1 - i] = (char)((carryOver + value_a ) % 2 + '0');
            carryOver = (carryOver + value_a) / 2;
            i++;
        }
        while(i < b.length()) {
            value_b = b.charAt(b.length() - 1 - i) - '0';
            temp[temp.length - 1 - i] = (char)((carryOver  + value_b) % 2 + '0');
            carryOver = (carryOver + value_b) / 2;
            i++;
        }
        if (carryOver != 0) {
            temp[0] =(char) ('0' + carryOver);
            return new String(temp);
        }
        else {
            return new String(Arrays.copyOfRange(temp, 1, length + 1));
        }
    }
}
