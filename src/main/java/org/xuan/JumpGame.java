package org.xuan;

/**
 * Created by xuan on 2015/12/13.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int currentIndex = 0;
        int previousIndex = 0;
        if (nums.length <= 1) {
            return true;
        }
        while(true) {
            if (currentIndex + nums[currentIndex] >= nums.length - 1) {
                return true;
            }
            int copy = currentIndex;
            for(int i = previousIndex + 1; i <= copy + nums[copy]; i++) {
                if (i + nums[i] > currentIndex + nums[currentIndex]) {
                    currentIndex = i;
                }
            }
            if (currentIndex == copy) {
                return false;
            }
            previousIndex = copy + nums[copy];
        }
    }
}
