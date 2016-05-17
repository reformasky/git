package org.xuan;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0) {
            return t == null || t.length() == 0;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] cache = new int[26];

        for(int i =0; i < s.length();i++) {
            cache[s.charAt(i) - 'a']++;
            cache[t.charAt(i) - 'a']--;
        }
        for(int i : cache) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
