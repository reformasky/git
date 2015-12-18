package org.xuan;

/**
 * Created by xuan on 2015/12/17.
 */
public class ValidNumber {
    public boolean isNumber(String s){
        int begin = 0;
        for(; begin < s.length(); begin++) {
            if (s.charAt(begin) != ' ') {
                break;
            }
        }
        if(begin == s.length()) {
            return false;
        }
        int end = s.length();
        for(int i = s.length() - 1; i >= begin; i--) {
            if(s.charAt(i) != ' ') {
                end = i + 1;
                break;
            }
        }
        char[] array = s.substring(begin, end).toCharArray();
        if (array[0] == '-' || array[0] == '+') {
            return isUnsignedNumber(array,1, false, true, true);
        }
        else {
            return isUnsignedNumber(array,0, false, true, true);
        }
    }

    private boolean isUnsignedNumber(char[] array, int index, boolean hasDigit, boolean canHaveDot, boolean canHaveE){
        if (index >= array.length) {
            return hasDigit;
        }
        char c = array[index];
        if (isDigit(c)) {
            return isUnsignedNumber(array, index + 1, true, canHaveDot, canHaveE);
        }
        if (c == '.') {
            if (!canHaveDot) {
                return false;
            }
            if (index + 1 >= array.length || isDigit(array[index+1]) || array[index+1] == 'e') {
                return isUnsignedNumber(array, index+1, hasDigit, false, canHaveE);
            }
            else {
                return false;
            }
        }
        if (c == 'e') {
            if (!canHaveE || !hasDigit || index+1 >= array.length) {
                return false;
            }
            if (isDigit(array[index+1])) {
                return isUnsignedNumber(array, index+1, hasDigit, false, false);
            }
            else if (array[index+1] == '+' || array[index+1] == '-') {
                return isInteger(array, index+2);
            }
            else {
                return false;
            }
        }
        return false;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    private boolean isInteger(char[] array, int index) {
        boolean result = false;
        for(int i = index; i < array.length; i++) {
            result = true;
            if (!isDigit(array[i])) {
                return false;
            }
        }
        return result;
    }
}
