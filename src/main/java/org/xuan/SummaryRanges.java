package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 4/21/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = nums[0],
                pre = nums[0];
        int curr;
        for(int i = 1; i < nums.length; i++) {
            curr = nums[i];
            if (curr == pre + 1) {
                pre = curr;
            }
            else {
                String entry = pre == start ? String.valueOf(start) : (String.valueOf(start) + "->" + String.valueOf(pre));
                result.add(entry);
                start = curr;
                pre = curr;
            }
        }
        String entry = pre == start ? String.valueOf(start) : (String.valueOf(start) + "->" + String.valueOf(pre));
        result.add(entry);
        return result;
    }
}
