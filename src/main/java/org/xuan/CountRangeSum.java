package org.xuan;

/**
 * Created by xzhou2 on 6/8/16.
 */
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] <= upper && nums[0] >= lower ? 1 : 0;
        }
        long[] sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        return helper(sums, lower, upper, 0, nums.length, new long[sums.length]);
    }

    private int helper(long[] sums, int lower, int higher, int low, int high, long[] temp) {
        if (high - low < 1) {
            return 0;
        }

        int mid = low + (high - low) /2;
        int res1 = helper(sums, lower, higher, low, mid, temp);
        int res2 = helper(sums, lower, higher, mid + 1, high, temp);
        int i = mid + 1, j = mid + 1;
        int res = res1 + res2;
        for(int index = low; index < mid + 1; index++) {
            while(i <= high && sums[i] - sums[index] <= higher) {
                i++;
            }
            while(j<= high && sums[j] - sums[index] < lower) {
                j++;
            }
            res += i - j;
        }
        merge(sums, low, mid, high, temp);
        return res;
    }

    private void merge(long[] sums, int low, int mid, int high, long[] temp) {
        for(int i = low; i <= high; i++) {
            temp[i] = sums[i];
        }
        int index = low, left = low, right = mid + 1;
        while(left <= mid && right <= high) {
            if (temp[left] < temp[right]) {
                sums[index++] = temp[left++];
            }
            else {
                sums[index++] = temp[right++];
            }
        }
        while(left <= mid) {
            sums[index++] = temp[left++];
        }
        while(right <= high) {
            sums[index++] = temp[right++];
        }

    }
}
