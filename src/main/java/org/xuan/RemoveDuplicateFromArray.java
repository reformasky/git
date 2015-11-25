package org.xuan;

public class RemoveDuplicateFromArray {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lastIndex = 0;
        for(int i = 0; i < nums.length;i++) {
            if (val != nums[i]) {
                nums[lastIndex++] = nums[i];
            }
        }
        return lastIndex;
    }
}
