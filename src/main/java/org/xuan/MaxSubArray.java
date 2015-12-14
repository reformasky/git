package org.xuan;

/**
 * Created by xuan on 2015/12/13.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE, temp = 0;
        int index = 0;
        boolean allNeg = true;
        while(index < nums.length) {
            if (nums[index] >= 0) {
                temp += nums[index];
                allNeg = false;
            }
            else {
                if(!allNeg) {
                    result = result < temp ? temp : result;
                }
                else {
                    result = result > nums[index] ? result : nums[index];
                }
                temp += nums[index];
                if (temp < 0) {
                    temp = 0;
                }
            }
            index++;
        }
        if (!allNeg) {
            result = result < temp ? temp : result;
        }
        return result;
    }
}
