package org.xuan;

/**
 * Created by xuan on 2016/2/2.
 */
public class IsInterleaved {
    public boolean isInterleave_1(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s2 == null ? s3 == null :
                    s2.compareTo(s3) == 0;
        }
        if (s2 == null || s2.length() == 0) {
            return s1.compareTo(s3) == 0;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s2 == null ? s3 == null : s2.compareTo(s3) == 0;
        }
        if (s2 == null || s2.length() == 0) {
            return s1.compareTo(s3) == 0;
        }
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int l1 = s1.length(),
                l2 = s2.length();

        boolean[] cache = new boolean[l2 + 1];
        cache[0] = true;
        for(int i = 0 ; i < l2; i++) {
            cache[i + 1] = s2.charAt(i) == s3.charAt(i);
            if (!cache[i]) {
                break;
            }
        }

        for(int i = 0; i < l1; i++) {
            cache[0] = cache[0] && s1.charAt(i) == s3.charAt(i);
            for(int j = 1; j <= l2; j++) {
                cache[j] = (cache[j-1] && s2.charAt(j -1) == s3.charAt(i + j))
                        || (cache[j] && s1.charAt(i) == s3.charAt(i+ j));
            }
        }
        return cache[l2];
    }

    private boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index1 == s1.length()) {
            return s2.substring(index2).compareTo(s3.substring(index3)) == 0;
        }
        if (index2 == s2.length()) {
            return s1.substring(index1).compareTo(s3.substring(index3)) == 0;
        }

        boolean result = false;
        if (s1.charAt(index1) == s3.charAt(index3)) {
            result = isInterleave(s1, s2, s3, index1 + 1, index2, index3 + 1);
            if (result) {
                return true;
            }
        }
        if (s2.charAt(index2) == s3.charAt(index3)) {
            result = isInterleave(s1, s2, s3, index1, index2 + 1, index3 + 1);
        }
        return result;
    }
}
