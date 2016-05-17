package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 4/25/16.
 */
public class MajorityElementII {
    public List<Integer> majority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int v1 = 0, v2 = 0;
        int c1 = 0, c2 = 0;
        for(int num : nums) {
            if (num == c1) {
                v1++;
            }
            else if (num == c2) {
                v2++;
            }
            else if (v1 == 0) {
                c1 = num;
                v1 = 1;
            }
            else if (v2 == 0) {
                c2 = num;
                v2 = 1;
            }
            else {
                v1--;
                v2--;
            }
        }


        int min = nums.length / 3 + 1;
        if (v1 > 0) {
            v1 = 0;
            for(int num : nums) {
                if (num == c1) {
                    v1++;
                }
            }
            if (v1 >= min) {
                result.add(c1);
            }
        }
        if (v2 > 0) {
            v2 = 0;
            for(int num : nums) {
                if (num == c2) {
                    v2++;
                }
            }
            if (v2 >= min) {
                result.add(c2);
            }
        }
        return result;
    }
}
