package org.xuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 5/26/16.
 */
public class IntersectArrayI {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        List<Integer> cache = new ArrayList<>(nums2.length);
        int value = 0;
        for(int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                cache.add(i);
            }
        }
        int[] result = new int[cache.size()];
        for(int i = 0; i < cache.size(); i++) {
            result[i] = cache.get(i);
        }
        return result;
    }
}
