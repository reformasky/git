package org.xuan;

/**
 * Created by xuan on 2015/11/12.
 */
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] criticalNumbers = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbles = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < criticalNumbers.length; i++) {
            while(num >= criticalNumbers[i]) {
                num -= criticalNumbers[i];
                sb.append(symbles[i]);
            }
        }
        return sb.toString();
    }
}
