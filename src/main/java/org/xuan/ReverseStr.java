package org.xuan;

/**
 * Created by xzhou2 on 5/27/16.
 */
public class ReverseStr {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while(low < high) {
            char temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
        return new String(arr);
    }
}
