package org.xuan;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by xuan on 2015/11/8.
 */
public class LongestSubStringWithNoDuplicate {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int[] characterIndexes = new int[128];
        for(int index = 0; index < characterIndexes.length; index++) {
            characterIndexes[index] = -1;
        }
        int beginIndex = 0;
        int endIndex;
        int longestLength = 0;
        int storedIndex;
        for(endIndex = 0; endIndex < s.length(); endIndex ++) {
            char currCharacter = s.charAt(endIndex);
            int index = currCharacter;
            if (characterIndexes[index] != -1) {
                storedIndex = characterIndexes[index];
                if(endIndex - beginIndex > longestLength) {
                    longestLength = endIndex - beginIndex ;
                }
                beginIndex = beginIndex > storedIndex + 1 ? beginIndex : storedIndex + 1;
            }
            characterIndexes[index] =  endIndex;
        }
        if (endIndex - beginIndex  > longestLength) {
            longestLength = endIndex - beginIndex;
        }
        return longestLength;
    }
}
