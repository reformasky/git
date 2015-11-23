package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<> ();
        if(nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for(int fourth = nums.length - 1; fourth >=3; fourth--) {
            int fourthValue = nums[fourth];
            ArrayList<ArrayList<Integer>> threeSumResult =  threeSum(nums, target - fourthValue, fourth);
            for(int i= 0; i < threeSumResult.size(); i++) {
                threeSumResult.get(i).add(fourthValue);
                result.add(threeSumResult.get(i));
            }
            while(fourth >= 3 && nums[fourth - 1] == fourthValue) {
                fourth--;
            }
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> threeSum(int[] nums, int target, int highestIndex) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int firstValue,
                secondValue;
        for(int first = 0; first < highestIndex - 2; first++) {
            firstValue = nums[first];
            for(int second = first + 1; second < highestIndex -1; second++) {
                secondValue = nums[second];
                if (Arrays.binarySearch(nums, second + 1, highestIndex, target - firstValue - secondValue) >= 0) {
                    ArrayList<Integer> temp = new ArrayList<>(3);
                    temp.add(firstValue);
                    temp.add(secondValue);
                    temp.add(target - firstValue - secondValue);
                    result.add(temp);
                }
                while(second < highestIndex - 1 &&  nums[second + 1] == secondValue) {
                    second++;
                }
            }
            while(first < highestIndex - 2 && nums[first +1 ] == firstValue) {
                first++;
            }
        }
        return result;
    }
}
