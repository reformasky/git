package org.xuan;

/**
 * Created by xzhou2 on 5/24/16.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        long num1 = 0, num2 = 0;
        for(int i = 0; i < num.length() - 2; i++) {
            num1 = 10 * num1 + num.charAt(i) - '0';
            num2 = 0;
            for(int j = i + 1; j < num.length() - 1; j++) {
                num2 = 10 * num2 + num.charAt(j) - '0';
                if (isValid(num, num1, num2, j+1)) {
                    return true;
                }
                if (num2 == 0) {
                    break;
                }
            }
            if (num1 == 0) {
                break;
            }
        }
        return false;
    }

    private boolean isValid(String num, long num1, long num2, int index) {
        if (index == num.length()) {
            return true;
        }
        long acc = 0, sum = num1 +  num2;
        for(int i = index; i < num.length(); i++) {
            acc = 10 * acc + num.charAt(i) - '0';
            if (acc == sum) {
                return isValid(num, num2, sum, i + 1);
            }
            if (acc == 0) {
                break;
            }
        }
        return false;
    }
}
