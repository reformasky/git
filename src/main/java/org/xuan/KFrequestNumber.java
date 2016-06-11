package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by xzhou2 on 5/30/16.
 */
public class KFrequestNumber {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        int[] values = new int[map.keySet().size()];
        int index = 0;
        for(int key : map.keySet()) {
            values[index++] = map.get(key);
        }

        int value = getTopKValue(values, k - 1, 0, values.length - 1);
        List<Integer> result = new ArrayList<>(k);
        List<Integer> equal = new ArrayList<>();
        for(int key : map.keySet()) {
            if (map.get(key) > value) {
                result.add(key);
            }
            else if (map.get(key) == value) {
                equal.add(key);
            }
        }
        int diff = Math.min(equal.size(),k - result.size());
        for(int i = 0; i < diff; i++) {
            result.add(equal.get(i));
        }
        return result;
    }

    public int getTopKValue(int[] values, int k, int low, int high) {
        if (low >= high) {

            return values[low];
        }

        int left = low, right = high + 1;
        int value = values[low];
        while(left < right) {
            while(left < high && values[++left] >= value);
            while(right > low && values[--right] <= value);
            if (right <= left) {
                break;
            }
            int temp = values[left];
            values[left] = values[right];
            values[right] = temp;
        }
        values[low] = values[right];
        values[right] = value;
        if (right == k) {
            return value;
        }
        else if (right < k) {
            return getTopKValue(values, k, right + 1, high);
        }
        else return getTopKValue(values, k, low, right - 1);

    }

    public String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a + ",");
        }
        return sb.toString();
    }
}
