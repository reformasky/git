package org.xuan;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xzhou2 on 4/15/16.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        assert nums.length >= k;
        Collections.shuffle(Arrays.asList(nums));
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int low, int high) {
        int val = nums[low];
        if (low >= high) {
            return nums[low];
        }
        int i = low, j = high + 1;
        while(true) {
            while(i < high && nums[++i] <= val);
            while(j >= low + 1 && nums[--j] >= val);
            if (i >= j) {
                break;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        if (nums.length - j == k) {
            return val;
        }
        else {
            nums[low] = nums[j];
            nums[j] = val;
            if (nums.length - j > k) {
                return findKthLargest(nums, k, j+ 1, high);
            }
            else {
                return findKthLargest(nums, k, low, j -1);
            }
        }
    }

}
