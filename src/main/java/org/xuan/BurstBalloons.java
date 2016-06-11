package org.xuan;

/**
 * Created by xzhou2 on 6/1/16.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][nums.length];
        for(int len = 1; len <= nums.length; len++) {
            for(int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for(int i = start; i <= end; i++) {
                    int curr = nums[i] * getNum(nums, start - 1) * getNum(nums, end + 1);
                    curr += (i == start ? 0 : dp[start][i -1]);
                    curr += (i == end ? 0 : dp[i + 1][end]);
                    dp[start][end] = Math.max(curr, dp[start][end]);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    private int getNum(int[] nums, int index) {
        if (index < 0 || index > nums.length - 1) {
            return 1;
        }
        return nums[index];
    }
}
