package org.xuan;

/**
 * Created by xzhou2 on 4/3/16.
 */
public class MaxGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int length = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = num < min ? num : min;
            max = num > max ? num : max;
        }

        int avgDiff = (max - min) / (length - 1);
        if (avgDiff == 0) {
            avgDiff++;
        }
        length = (max - min) / avgDiff + 1;
        int[] localMin = new int[length], localMax = new int[length];
        for (int num : nums) {
            int index = (num - min) / avgDiff;
            if (localMin[index] == 0|| localMin[index] > num) {
                localMin[index] = num;
            }
            if (localMax[index] < num) {
                localMax[index] = num;
            }
        }
        int result = 0;
        int preMax = 0;
        for(int i = 1; i < length; i++) {
            if (localMax[i-1] != 0) {
                preMax = localMax[i-1];
            }
            result = Math.max(result, localMin[i] - preMax);
        }
        return result;
    }
}
