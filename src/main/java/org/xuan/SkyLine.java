package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 4/25/16.
 */
public class SkyLine {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return result;
        }
        return divide(buildings, 0, buildings.length -1);
    }

    private List<int[]> divide(int[][] buildings, int begin, int end) {
        if (begin == end) {
            List<int[]> result = new ArrayList<>();
            result.add(new int[]{buildings[begin][0], buildings[begin][2]});
            result.add(new int[]{buildings[begin][1], 0});
            return result;
        }
        int mid = begin + (end - begin)/2;
        List<int[]> left = divide(buildings, begin, mid);
        List<int[]> right = divide(buildings, mid + 1, end);
        return merge(left, right);
    }

    private List<int[]> merge(List<int[]> left, List<int[]> right) {
        List<int[]> result = new ArrayList<>();
        int index1 = 0, index2 = 0;
        int skyLine = 0;
        int h1 = 0, h2 = 0;
        while(index1 < left.size() && index2< right.size()) {
            int[] c1 = left.get(index1);
            int[] c2 = right.get(index2);
            int curr;
            if (c1[0] < c2[0]) {
                curr = c1[0];
                h1 = c1[1];
                index1++;
            }
            else if (c1[0] > c2[0]){
                curr = c2[0];
                h2 = c2[1];
                index2++;
            }
            else {
                curr = c1[0];
                h1 = c1[1];
                h2 = c2[1];
                index1++;
                index2++;
            }

            if(skyLine != Math.max(h1, h2)) {
                skyLine = Math.max(h1, h2);
                result.add(new int[]{curr, skyLine});
            }
        }

        for(; index1 < left.size(); index1++) {
            result.add(left.get(index1));
        }
        for(; index2 < right.size(); index2++) {
            result.add(right.get(index2));
        }
        return result;
    }
}
