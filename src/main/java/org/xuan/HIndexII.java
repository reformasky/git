package org.xuan;

/**
 * Created by xzhou2 on 5/17/16.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        if (citations[0] >= citations.length) {
            return citations.length;
        }
        if (citations[citations.length - 1] == 0) {
            return 0;
        }
        return hIndex(citations, 0, citations.length);
    }

    private int hIndex(int[] arr, int low, int high) {

        int mid = low + (high - low) /2;
        int h = arr.length - mid;
        if (arr[mid] >= h && arr[mid - 1] <=h) {
            return h;
        }
        if (arr[mid] >= h) {
            return hIndex(arr, low, mid - 1);
        }
        else {
            return hIndex(arr, mid + 1, high);
        }
    }
}
