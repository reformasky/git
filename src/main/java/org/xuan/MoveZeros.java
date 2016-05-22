package org.xuan;

import java.util.Arrays;

/**
 * Created by xzhou2 on 5/19/16.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int nonzero = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nonzero = Math.max(nonzero, i+1);
                for(; nonzero < nums.length; nonzero++) {
                    if (nums[nonzero] != 0) {
                        break;
                    }
                }
                if (nonzero == nums.length) {
                    return;
                }
                nums[i] = nums[nonzero];
                nums[nonzero] = 0;
            }
        }
    }
}
