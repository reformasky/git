package org.xuan;

/**
 * Created by xzhou2 on 5/22/16.
 */
public class LengthOfLongestIncreasingSubArray {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] cache = new int[nums.length];
        cache[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            helper(nums, i, cache);
        }
        helper(nums, 1, cache);
        int result = 0;
        for(int i : cache) {
            result = Math.max(result, i);
        }
        return result;
    }

    private void helper(int[] nums, int index, int[] cache) {
        if (index >= nums.length) {
            return;
        }
        int num = nums[index];
        int result = 1;
        for(int i = 0; i < index; i++) {
            if (num > nums[i]) {
                result = Math.max(result, cache[i] + 1);
            }
        }
        cache[index] = result;
    }
}
