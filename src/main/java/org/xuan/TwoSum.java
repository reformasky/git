package org.xuan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuan on 2015/11/4.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0 ; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && nums[i] * 2 == target) {
                return new int[] {map.get(nums[i]), i + 1};
            }
            else {
                map.put(nums[i], i + 1);
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i]) && (i + 1 != map.get(target - nums[i]))) {
                return new int[] {i + 1, map.get(target - nums[i])};
            }
        }
        return null;
    }
}
