package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2015/12/21.
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(temp);
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        Integer[] cache = new Integer[nums.length];
        dfs(nums, 0, -1, cache, result);
        return result;
    }

    private void dfs(int[] nums, int index, int lastIndex, Integer[] cache, List<List<Integer>> result) {
        if (index == cache.length) {
            return;
        }
        else {
            for(int i = lastIndex + 1; i < nums.length; i++) {
                cache[index] = nums[i];
                Integer[] temp =  Arrays.copyOfRange(cache, 0, index+1);
                result.add(new ArrayList<>(Arrays.asList(temp)));
                dfs(nums, index + 1, i, cache, result);
            }
        }
    }
}
