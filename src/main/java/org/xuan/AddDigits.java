package org.xuan;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num <= 9) {
            return num;
        }
        int result = 0;
        while(num > 0) {
            result += num % 10;
            num = num /10;
        }
        return addDigits(result);
    }
}
