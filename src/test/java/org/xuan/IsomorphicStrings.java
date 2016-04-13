package org.xuan;

/**
 * Created by xzhou2 on 4/12/16.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0) {
            return t == null || t.length() == 0;
        }
        char[] forward =  new char[128];
        char[] back = new char[128];
        for(int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            char f = forward[cs], b = back[ct];
            if (f == 0) {
                if (b != 0) {
                    return false;
                }
                else {
                    forward[cs] = ct;
                    back[ct] = cs;
                }
            }
            else if (b == 0) {
                return false;
            }
            else {
                if (cs != b || ct != f) {
                    return false;
                }
            }
        }
        return true;
    }
}
