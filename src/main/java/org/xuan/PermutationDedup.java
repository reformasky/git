package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationDedup {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        return permuteUnique(nums, nums.length - 1);
    }

    private List<List<Integer>> permuteUnique(int[] nums, int highestIndex) {
        if (highestIndex == 0) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> element = new ArrayList<>(1);
            element.add(nums[0]);
            result.add(element);
            return result;
        }
        List<List<Integer>> last = permuteUnique(nums, highestIndex - 1);
        return addElement(last, nums[highestIndex]);
    }

    private List<List<Integer>> addElement(List<List<Integer>> last, int num) {
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> list : last) {
            addElement(list, num, result);
        }
        return result;
    }

    private void addElement(List<Integer> last, int num, List<List<Integer>> result) {
        int index = last.lastIndexOf(num);
        Integer[] temp = new Integer[last.size() + 1];
        for(int j = 0; j <= index; j++) {
            temp[j] = last.get(j);
        }
        for(int i = index + 1; i <= last.size(); i++) {
            for(int j = index + 1; j < i; j++) {
                temp[j] = last.get(j);
            }
            temp[i] = num;
            for(int j = i + 1; j< temp.length; j++) {
                temp[j] = last.get(j -1);
            }
            result.add(new ArrayList<>(Arrays.asList(temp)));
        }
    }
}
