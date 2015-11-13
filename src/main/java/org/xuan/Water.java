package org.xuan;

/**
 * Created by xuan on 2015/11/12.
 */
public class Water {
    public int maxArea(int[] height) {
        int result = 0;
        if (height == null || height.length < 2) {
            return result;
        }

        int leftHighest = height[0];
        int rightHighest;
        int currentArea;
        for(int left = 0; left < height.length - 1; left++) {
            int leftHeight = height[left];
            int rightHeight;
            rightHighest = height[height.length - 1];
            if (leftHeight <= leftHighest && left > 0) {
                continue;
            }
            else {
                leftHighest = leftHeight;
            }
            for(int right = height.length - 1; right > left; right--) {
                rightHeight = height[right];
                if (rightHeight >= leftHeight) {
                    currentArea = (right - left) * leftHeight;
                    result = currentArea > result ? currentArea : result;
                    break;
                }
                else if (rightHeight <= rightHighest && right < height.length - 1){
                    continue;
                }
                else {
                    rightHighest = rightHeight;
                    currentArea = (right - left) * rightHeight;
                    result = currentArea > result ? currentArea : result;
                }
            }
        }

        return result;
    }
}
