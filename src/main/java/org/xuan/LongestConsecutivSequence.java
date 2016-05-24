package org.xuan;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuan on 2016/3/16.
 */
public class LongestConsecutivSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        Set<Integer> set = new HashSet<>(nums.length);
        for(int num : nums) {
            set.add(num);
        }

        int currNum, currResult;
        for(int num : nums) {

            if (set.contains(num)) {
                set.remove(num);
                currResult = 1;
                currNum = num - 1;
                while(set.contains(currNum)) {
                    currResult++;
                    set.remove(currNum);
                    currNum--;

                }
                currNum = num + 1;
                while(set.contains(currNum)) {
                    currResult++;
                    set.remove(currNum);
                    currNum++;
                }
                result = Math.max(result, currResult);
            }
        }
        
        String[][] m = new String[][] {{null}, {null}};
        return result;
    }

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] tails = new int[nums.length];
        int len = 0;
        tails[len++] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int low = 0, high = len;
            while(low != high) {
                int mid = low + (high - low) /2;
                if (tails[mid] < num) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            tails[low] = num;
            if(low == len) {
                len++;
            }
        }
        return len;
    }
}
