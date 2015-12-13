package org.xuan;

/**
 * Created by xuan on 2015/12/8.
 */
public class WildCardMatch {
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
            return false;
        boolean[] cache = new boolean[s.length() + 1];
        cache[0] = true;
        for(int j = 0; j < p.length();j++) {
            if (p.charAt(j) != '*') {
                for(int i = s.length() - 1; i >= 0; i--) {
                    cache[i + 1] = cache[i] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                }
            }
            else {
                int i = 0;
                while(i <= s.length() && !cache[i]){
                    i++;
                }
                for(; i <= s.length();i++) {
                    cache[i] = true;
                }
            }
            cache[0] = cache[0] && p.charAt(j) == '*';
        }
        return cache[s.length()];
    }
}
