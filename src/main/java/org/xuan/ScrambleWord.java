package org.xuan;

/**
 * Created by xuan on 2016/2/22.
 */
public class ScrambleWord {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null) {
            return s2 == null;
        }
        if (s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray(),
                c2 = s2.toCharArray();
        if (!isCandidate(c1, 0, c1.length - 1, c2, 0, c2.length - 1)) {
            return false;
        }
        return isScramble(c1, 0, c1.length - 1, c2, 0, c2.length - 1);
    }

    private boolean isScramble(char[] c1, int begin1, int end1, char[] c2, int begin2, int end2) {
        if (begin1 > end1) {
            return begin2 > end2;
        }
        if (begin1 == end1) {
            return begin2 == end2 && c1[begin1] == c2[begin2];
        }
        for(int i = begin1; i < end1; i++) {
            if (isCandidate(c1, begin1, i, c2, begin2, i - begin1 + begin2)) {
                if (isScramble(c1, begin1, i, c2, begin2, i - begin1 + begin2) &&
                        isScramble(c1, i + 1, end1, c2, i - begin1 + begin2 + 1, end2)) {
                    return true;
                }
            }
            if (isCandidate(c1, begin1, i, c2, end2 - i + begin1, end2)) {
                if (isScramble(c1, begin1, i, c2, end2 - i + begin1, end2) &&
                        isScramble(c1, i + 1, end1, c2, begin2, end2 - i + begin1 - 1) ) {
                    return true;
                }
            }
        }
        return false;
    }

    //assume the lengthes of the arrays are the same;
    private boolean isCandidate(char[]c1, int begin1, int end1, char[] c2, int begin2, int end2) {
        int[] counts = new int[128];
        for(int i = begin1; i <= end1; i++) {
            counts[c1[i] - '0']++;
        }
        for(int i = begin2; i <= end2;i++) {
            counts[c2[i] - '0']--;
        }
        for(int i = 0; i < 128;i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
