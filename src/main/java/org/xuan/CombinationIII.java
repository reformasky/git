package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 4/18/16.
 */
public class CombinationIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] arr = new Integer[k];
        helper(arr, 0, n, result);
        return result;
    }

    private void helper(Integer[] arr, int index, int n, List<List<Integer>> result) {
        int beginValue = (index == 0 ? 1 : (arr[index-1] + 1));
        int endValue = (9 - arr.length + index + 1);
        for(int i = beginValue; i <= endValue; i++) {
            if (n > i && index < arr.length -1) {
                arr[index] = i;
                helper(arr, index+1, n - i, result);
            }
            else if (n == i && index == arr.length - 1) {
                arr[index] = i;
                result.add(new ArrayList<Integer>(Arrays.asList(arr)));
            }
        }
    }
}
