package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 6/1/16.
 */
public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        Triple[] cache = new Triple[nums.length];
        Triple[] temp = new Triple[nums.length];
        for(int i = 0; i < nums.length; i++) {
            cache[i] = new Triple(nums[i], 0, i);
        }
        mergeSort(cache, 0, cache.length - 1, temp);
        Integer[] result = new Integer[cache.length];
        for(Triple t : cache) {
            result[t.i] = t.s;
        }
        return Arrays.asList(result);
    }

    private void mergeSort(Triple[] arr, int low, int high, Triple[] temp) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) /2;
        mergeSort(arr, low, mid, temp);
        mergeSort(arr, mid + 1, high, temp);
        merge(arr, low, mid, high, temp);
    }


    private void merge(Triple[] arr, int low, int mid, int high, Triple[] temp) {
        for(int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int left = low, right = mid +1, index = low;

        while(left <= mid && right <= high) {
            if (temp[left].v <= temp[right].v) {
                temp[left].s += (right - mid -1);
                arr[index++] = temp[left++];
            }
            else {
                arr[index++] = temp[right++];
            }
        }
        while(left <= mid) {
            temp[left].s += (high - mid);
            arr[index++] = temp[left++];
        }
        while(right <= high) {
            arr[index++] = temp[right++];
        }
    }

    class Triple{
        int v;
        int s;
        int i;

        public Triple(int value, int smaller, int index) {
            v = value;
            s = smaller;
            i = index;
        }
    }
}
