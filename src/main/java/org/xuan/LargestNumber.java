package org.xuan;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 4/5/16.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int length = 0;
        boolean hasPos = false;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                hasPos = true;
            }
            strs[i] = String.valueOf(nums[i]);
            length += strs[i].length();
        }
        if (!hasPos) {
            return "0";
        }
        Arrays.sort(strs, new StringComparator());
        StringBuilder sb = new StringBuilder(length);
        for(String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    class StringComparator implements Comparator<String> {
        public int compare(String obj1, String obj2) {
            if (obj1.length() < obj2.length()) {
                return 0  - compare(obj2, obj1);
            }

            for(int i = 0; i < obj2.length(); i++) {
                if (obj1.charAt(i) > obj2.charAt(i)) {
                    return -1;
                }
                else if (obj1.charAt(i) < obj2.charAt(i)) {
                    return 1;
                }
            }
            if (obj1.length() == obj2.length()) {
                return 0;
            }
            return compare(obj1.substring(obj2.length()), obj2);
        }
    }
}
