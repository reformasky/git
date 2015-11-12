package org.xuan;

/**
 * Created by xuan on 2015/11/11.
 */
public class AtoI {
    public int myAtoi(String str) {
        boolean isNeg = false;
        long result = 0L;
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;
        char current;
        while(index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index < str.length()) {
            if (str.charAt(index) == '-') {
                isNeg = true;
                index++;
            }
            else if (str.charAt(index) == '+') {
                index++;
            }
        }

        while(index < str.length()) {
            current = str.charAt(index++);
            if (current > '9' || current < '0') {
                break;
            }
            else {
                result = 10 * result + current - '0';
                if (!isNeg && Integer.MAX_VALUE <= result) {
                    return Integer.MAX_VALUE;
                }
                else if (isNeg && Integer.MIN_VALUE >= -result) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        result =  isNeg ? -result : result;
        return (int)result;
    }
}
