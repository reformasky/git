package org.xuan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuan on 2015/12/11.
 */
public class JumpGame_2 {
    public int jump_BFS(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] steps = new int[nums.length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int currentIndex = queue.remove();
            int maxSteps = Math.min(nums[currentIndex], nums.length - currentIndex - 1);
            for (int j = maxSteps; j >= 1; j--) {
                int i = currentIndex + j;
                if (steps[i] > steps[currentIndex] + 1) {
                    steps[i ] = steps[currentIndex] + 1;
                    if (i == nums.length - 1) {
                        return steps[i];
                    }
                    queue.add(i);
                }
            }
        }
        return steps[nums.length - 1];
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int result = 0;
        int index = 0;
        int previousHigh = 0;
        while(true) {
            if(index + nums[index] >= nums.length - 1) {
                return ++result;
            }
            int high = index,
                    tempIndex = index;
            for(int i = previousHigh + 1; i <= tempIndex + nums[tempIndex]; i++) {
                if (high < i + nums[i]) {
                    high = i + nums[i];
                    index = i;
                }
            }
            result++;
            previousHigh = tempIndex + nums[tempIndex];
        }
    }
}
