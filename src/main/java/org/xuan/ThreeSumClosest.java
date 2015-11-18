package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2015/11/17.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new AssertionError();
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE,
                left, right;
        for (int current = 0; current < nums.length - 2; current++) {
            left = current + 1;
            right = nums.length - 1;
            while(left < right ) {
                int diff = nums[current] + nums[left] + nums[right] - target;
                if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff =diff;
                }
                if (diff == 0) {
                    return target;
                }
                else if (diff < 0) {
                    left ++;
                }
                else {
                    right --;
                }
            }
        }
        return minDiff + target;
    }
}
