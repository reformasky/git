package org.xuan;

/**
 * Created by xzhou2 on 6/14/16.
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i : nums) {
            if (i > min2) {
                return true;
            }
            else if (i > min1) {
                min2 = i;
            }
            else {
                min1 = i;
            }
        }
        return false;
    }
}
