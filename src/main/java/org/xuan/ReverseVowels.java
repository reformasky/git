package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 5/23/16.
 */
public class ReverseVowels {
    private static List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int left = -1, right = arr.length;
        while(true) {
            while(left < arr.length - 1 && ! vowels.contains(arr[++left]));
            while(right > 0 && ! vowels.contains(arr[--right]));
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            else {
                break;
            }
        }
        return new String(arr);
    }
}
