package org.xuan;

import java.util.Stack;

/**
 * Created by xuan on 2016/1/13.
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] height) {
        if ((height == null) || (height.length == 0)) return 0;
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i = 0;  i < height.length; i++) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
            }
            else {
                int index = stack.pop();
                int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                area = Math.max(area, w * height[index]);
                i--;
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int w = stack.isEmpty()? (height.length) : (height.length - stack.peek() - 1);
            area = Math.max(area, w * height[index] );
        }
        return area;
    }
}
