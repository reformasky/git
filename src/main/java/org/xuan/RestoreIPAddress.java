package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2016/1/31.
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 3 || s.length() > 12) {
            return result;
        }
        int[] begins = new int[4];
        begins[0] = 0;
        restoreIpAddress(s, begins, 0, result);
        return result;

    }

    private boolean restoreIpAddress(String s, int[] begins, int index, List<String> result) {
        if (index == 3 ) {
            if (isValid(s, begins, index)) {
                result.add(toIpAddress(s, begins));
                return true;
            }
            else {
                return false;
            }

        }
        boolean flag = false;
        for (int i = begins[index] + 1; i <= Math.min(begins[index] + 3, s.length()); i++) {
            begins[index + 1] = i;
            if (isValid(s, begins, index) && restoreIpAddress(s, begins, index + 1, result)) {
                flag = true;
            }
        }
        return flag;
    }

    private String toIpAddress(String s, int[] begins) {
        StringBuilder sb = new StringBuilder(s.length() + 3);
        for(int i = 0; i < 4; i++) {
            int begin = begins[i];
            int end = i < begins.length -1 ? begins[i + 1]: s.length();
            sb.append(s.substring(begin, end));
            if (end != s.length()) {
                sb.append('.');
            }
        }
        return sb.toString();
    }

    private boolean isValid(String s, int[] begins, int index) {
        int begin = begins[index];
        int end = index < begins.length -1 ? begins[index + 1] -1: s.length() -1;
        if (end - begin < 0 || end - begin > 2) {
            return false;
        }
        switch(s.charAt(begin)) {
            case '0': return begin == end;
            case '1': return end - begin <= 2;
            case '2': return (end - begin <= 1) || (end - begin == 2 && (s.charAt(begin + 1) < '5' || (s.charAt(begin + 1) == '5' && s.charAt(end) <= '5')));
            default:
                return end - begin <= 1;
        }
    }
}