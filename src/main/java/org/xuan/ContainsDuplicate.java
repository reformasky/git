package org.xuan;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 4/12/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for(int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
