package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2016/1/26.
 */
public class SubSetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;) {
            int previousSize = result.size();
            int value = nums[i];
            for(int j = 0; j < previousSize; j++) {
                List<Integer> l = result.get(j);
                Integer[] temp = new Integer[l.size() + 1];
                copyListToArray(l, temp);
                temp[temp.length - 1] = value;
                result.add(new ArrayList(Arrays.asList(temp)));
            }
            while(++i < nums.length && nums[i] == value) {
                int currentSize = result.size();
                for(int j = previousSize; j < currentSize; j++) {
                    List<Integer> l = result.get(j);
                    Integer[] temp = new Integer[l.size() + 1];
                    copyListToArray(l, temp);
                    temp[temp.length - 1] = value;
                    result.add(new ArrayList(Arrays.asList(temp)));
                }
                previousSize = currentSize;
            }
        }
        return result;
    }

    private void copyListToArray(List<Integer> list, Integer[] arr) {
        int i = 0;
        for(Integer v : list) {
            arr[i++] = v;
        }
    }
}
