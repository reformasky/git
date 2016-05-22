package org.xuan;

/**
 * Created by xzhou2 on 5/20/16.
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        return findDuplicate(nums, 1, nums.length -1);
    }

    private int findDuplicate(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }

        int mid = low + (high - low)/2;
        int countLess = 0;
        for(int num : nums) {
            if (num <= mid) {
                countLess++;
            }
        }

        if (countLess > mid) {
            return findDuplicate(nums, low, mid);
        }
        else {
            return findDuplicate(nums, mid + 1, high);
        }
    }
}
