package org.xuan;

/**
 * Created by xzhou2 on 4/17/16.
 */
public class RobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int begin, int end) {
        assert begin < end;
        int pre = 0, curr = 0;
        for(int i = begin; i < end; i++) {
            int temp = pre;
            pre = curr;
            curr = Math.max(curr, temp + nums[i]);

        }
        return curr;
    }
}
