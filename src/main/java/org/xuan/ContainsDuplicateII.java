package org.xuan;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 4/18/16.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        if (k == 0) {
            return false;
        }

        Set<Integer> cache = new HashSet<Integer>(k);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (cache.contains(num)) {
                return true;
            }
            if (cache.size() >= k) {
                cache.remove(new Integer(nums[i - k]));
            }
            cache.add(num);
        }
        return false;
    }
}
