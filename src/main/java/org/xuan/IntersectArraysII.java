package org.xuan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 5/26/16.
 */
public class IntersectArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        Set<Integer> set = new HashSet<>(nums1.length);
        for(int i : nums1) {
            set.add(i);
        }
        List<Integer> temp = new ArrayList<>(nums2.length);
        for(int i : nums2) {
            if (set.contains(i)) {
                temp.add(i);
                set.remove(i);
            }
        }
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
