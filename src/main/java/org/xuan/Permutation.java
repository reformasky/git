package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2015/12/3.
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Arrays.asList(Arrays.asList(new Integer[]{}));
        }

        return permute(nums, nums.length - 1);
    }

    private List<List<Integer>> permute(int[] nums, int index) {
        if (index == 0) {
            return Arrays.asList(Arrays.asList(new Integer[]{nums[0]}));
        }
        List<List<Integer>> previousResult = permute(nums, index - 1);
        return add(nums[index], previousResult);
    }

    private List<List<Integer>> add(int value, List<List<Integer>> previousResult) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : previousResult) {
            for(int i = 0; i < list.size() + 1; i++) {
                Integer[] cache = new Integer[list.size() + 1];
                int j = 0;
                while(j < cache.length) {
                    if (j == i) {
                        cache[j] = value;
                    }
                    else if (j < i) {
                        cache[j] = list.get(j);
                    }
                    else {
                        cache[j] = list.get(j - 1);
                    }
                    j++;
                }
                result.add(Arrays.asList(cache));
            }
        }
        return result;
    }
}
