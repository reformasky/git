package org.xuan;

/**
 * Created by xuan on 2015/11/13.
 */
public class CommonPreFix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for(String s : strs) {
            if (s == null) {
                return "";
            }
        }
        int endIndex = 0;
        char currentChar;
        while(endIndex < strs[0].length()) {
            currentChar = strs[0].charAt(endIndex);
            for(int i = 1; i < strs.length; i++) {
                if (endIndex >= strs[i].length() || strs[i].charAt(endIndex) != currentChar) {
                    return strs[0].substring(0, endIndex);
                }
            }
            endIndex++;
        }
        return strs[0].substring(0, endIndex);
    }
}
