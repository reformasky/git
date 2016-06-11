package org.xuan;

import util.FindKthNumber;

/**
 * Created by xzhou2 on 6/6/16.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int mid = FindKthNumber.findKthNumber(nums, (nums.length - 1) /2);
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[map(nums, index)] > mid) {
                swap(nums, map(nums, left++), map(nums, index++));
            }
            else if (nums[map(nums, index)] < mid) {
                swap(nums, map(nums, index), map(nums, right--));
            }
            else {
                index++;
            }
        }
    }

    private int map(int[] nums, int k) {
        return  (1 + k * 2) % (nums.length | 1);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
