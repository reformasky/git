package org.xuan;

/**
 * Created by xzhou2 on 5/17/16.
 */
public class NumToWords {
    private final static int[] values = new int[]{(int)Math.pow(10, 9), (int)Math.pow(10, 6), (int)Math.pow(10, 3), 100, 90, 80, 70,60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5,4,3,2,1};
    private final static String[] strings = new String[]{"Billion", "Million", "Thousand", "Hundred", "Ninety","Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two","One"};
    private final static int index1 = 2;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= index1; i++) {
            int q = num / values[i];
            if (q > 0) {
                sb.append(numberToWords(q));
                sb.append(" " + strings[i]);
            }
            num %= values[i];
            if (q > 0 && num > 0) {
                sb.append(" ");
            }
        }

        int q = num / values[3];
        if (q > 0) {
            sb.append(numberToWords(q));
            sb.append(" " + strings[3]);
        }
        num %= values[3];
        if (q > 0 && num > 0) {
            sb.append(" ");
        }

        for(int i = 4; i < values.length; i++) {
            if (num >= values[i]) {
                num -= values[i];
                sb.append(strings[i]);
                if (num > 0) {
                    sb.append(" ");
                }
            }
        }

        assert num == 0;
        return sb.toString();
    }
}
