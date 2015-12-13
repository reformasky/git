package org.xuan;

/**
 * Created by xuan on 2015/12/8.
 */
public class StringMultiply {
    public String multiply(String s1, String s2) {
        if (s1 == null || s1.length() == 0
                || s2 == null || s2.length() == 0) {
            return "";
        }
        if (s1.charAt(0) == '-' && s2.charAt(0) != '-') {
            return multiply(s1.substring(1, s1.length()), s2, true);
        }
        else if (s1.charAt(0) != '-' && s2.charAt(0) == '-') {
            return multiply(s1, s2.substring(1, s2.length()), true);
        }
        else if (s1.charAt(0) == '-' && s2.charAt(0) == '-') {
            return multiply(s1.substring(1, s1.length()), s2.substring(1, s2.length()), false);
        }
        return multiply(s1, s2, false);

    }

    private String multiply(String s1, String s2, boolean isNegative) {
        if (s1.length() > s2.length()) {
            return multiply(s2, s1, isNegative);
        }
        byte[] cache = new byte[]{};
        for(int i = s2.length() - 1; i >= 0; i--) {
            int number = s2.charAt(i) - '0';
            cache = add(cache, multiply(s1, number, s2.length() - i - 1));
        }

        StringBuilder sb = new StringBuilder();
        boolean hasNumber = false;
        if (isNegative) {
            sb.append('-');
        }
        int i = cache.length - 1;
        while(i >= 0 && cache[i] == 0) {
            i--;
        }
        if (i >= 0) {
            hasNumber = true;
        }
        for(; i>=0; i--) {

            sb.append(cache[i]);
        }

        return hasNumber? sb.toString() : "0";
    }



    //returns in reverse order
    public byte[] multiply(String s, int number, int endingZeros) {
        byte[] result = new byte[s.length() + 1 + endingZeros];
        int j;
        for(j = 0; j < endingZeros; j++) {
            result[j] = 0;
        }
        int carryOver = 0, value = 0;
        int temp;
        for(int i = s.length() - 1; i >= 0; i--, j++) {
            temp = (s.charAt(i) - '0') * number + carryOver;
            carryOver = temp / 10;
            result[j] = (byte) (temp % 10);
        }
        result[j] = (byte)carryOver;
        return result;
    }
    // r1 should always no longer than r2
    public byte[] add(byte[] r1, byte[] r2) {

        byte[] result = new byte[r2.length + 1];
        int carryOver = 0;
        int i;
        for(i = 0; i < r1.length; i++) {
            int temp = (r1[i] + r2[i] + carryOver);
            carryOver = temp / 10;
            result[i] = (byte) (temp % 10);
        }
        for(; i < r2.length;i++) {
            int temp = (r2[i] + carryOver);
            carryOver = temp / 10;
            result[i] = (byte) (temp % 10);
        }
        result[i] = (byte)carryOver;
        return result;
    }
}
