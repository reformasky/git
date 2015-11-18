package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2015/11/16.
 */
public class ThreeSum_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        int[] copiedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copiedArray);
        int firstValue, secondValue, thirdValue;
        for (int first = 0; first < copiedArray.length - 2; first++) {
            firstValue = copiedArray[first];
            for(int second = first + 1; second < copiedArray.length - 1;second++) {
                secondValue = copiedArray[second];
                int third = Arrays.binarySearch(copiedArray, second +1 , copiedArray.length ,-(firstValue + secondValue));
                if ( third > second) {
                    result.add(Arrays.asList(new Integer[]{firstValue, secondValue, -(firstValue + secondValue)}));
                }
                while(second < copiedArray.length -1 && copiedArray[second+ 1] == secondValue) {
                    second++;
                }

            }
            while(first < copiedArray.length -1 && copiedArray[first+ 1] == firstValue) {
                first++;
            }

        }
        return  result;

    }

}
