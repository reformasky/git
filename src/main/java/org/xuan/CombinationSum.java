package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2015/12/2.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        return combinationSum(candidates, candidates.length - 1, target);
    }

    private  List<List<Integer>> combinationSum(int[] sortedArray, int index, int target) {
        List<List<Integer>> result = new ArrayList<>() ;
        if (target < 0) {
            return result;
        }
        else if (target== 0) {
            List<Integer> element = new ArrayList();
            result.add(element);
            return result;
        }

        for(int i = index; i >= 0; i--) {
            List<List<Integer>> temp = combinationSum(sortedArray, i, target - sortedArray[i]);
            if (! temp.isEmpty()) {
                for (List<Integer> element : temp) {
                    element.add(sortedArray[i]);
                    result.add(element);
                }
            }
        }
        return result;
    }
}
