package org.xuan;

import util.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 3/28/16.
 */
public class MaxPointsOnALine {
    /*public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        int length = points.length;
        List<Map<Pair, List<Integer>>> cache = new ArrayList<>(length);
        boolean[] isValid = new boolean[length];
        int result = 2;
        for(int i = 0; i < length; i++) {
            Point point = points[i];
            if (length - i + 1<= result) {
                break;
            }
            Arrays.fill(isValid, true);
            for(int j = 0; j < i; j++) {
                Pair pair = new Pair(point.x - points[j].x, point.y - points[j].y);
                if (pair.equals(new Pair(0,0))) {
                    continue;
                }
                List<Integer> noValid = cache.get(j).get(pair);
                if (noValid != null) {
                    for(Integer index : noValid) {
                        isValid[index] = false;
                    }
                }

            }

            Map<Pair, List<Integer>> map = new HashMap<>();
            List<Integer> same = new ArrayList<>();
            for(int j = i + 1; j < length; j++) {
                if (isValid[j]) {
                    Pair pair = new Pair(points[j].x - point.x, points[j].y - point.y);
                    if (pair.equals(new Pair(0, 0))) {
                        same.add(j);
                    }
                    else {
                        if (map.containsKey(pair)) {
                            List list = map.get(pair);
                            list.add(j);
                            result = Math.max(result, list.size());
                        }
                        else {
                            List<Integer> list = new ArrayList<>();
                            list.add(i);
                            list.add(j);
                            map.put(pair, list);
                        }
                    }
                }
            }
            if (!same.isEmpty()) {
                for(Map.Entry<Pair, List<Integer>> entry : map.entrySet()) {
                    entry.getValue().addAll(same);
                    result = Math.max(result, entry.getValue().size());
                }
                result = Math.max(result, same.size() + 1);
            }


            cache.add(map);
        }
        return result;

    }*/

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        int length = points.length;
        int result = 2;
        for (int i = 0; i < length; i++) {
            Point point = points[i];
            if (length - i + 1 <= result) {
                break;
            }


            Map<Pair, Integer> map = new HashMap<>();
            int same = 0;
            for (int j = i + 1; j < length; j++) {

                Pair pair = new Pair(points[j].x - point.x, points[j].y - point.y);
                if (pair.equals(new Pair(0, 0))) {
                    same++;
                } else {
                    if (map.containsKey(pair)) {
                        int value = map.get(pair);
                        value++;
                        map.put(pair, value);
                        result = Math.max(result, value);
                    } else {
                        map.put(pair, 2);
                    }
                }

            }
            if (same != 0 && !map.isEmpty()) {
                for (Pair p : map.keySet()) {
                    int value = map.get(p);
                    value += same;
                    result = Math.max(result, value);
                }
            } else {
                result = Math.max(result, same + 1);
            }
        }
        return result;

    }


    class Pair {
        int dx, dy;

        Pair(int x, int y) {
            if (x != 0 && y != 0) {
                int d = gcd(x, y);
                dx = x / d;
                dy = y / d;
            } else if (x == 0 && y != 0) {
                dx = 0;
                dy = 1;
            } else if (x != 0 && y == 0) {
                dx = 1;
                dy = 0;
            } else {
                dx = 0;
                dy = 0;
            }

        }

        @Override
        public boolean equals(Object that) {
            if (that instanceof Pair) {
                Pair cast = (Pair) that;
                return dx == cast.dx && dy == cast.dy;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return dx * 31 + dy;
        }

        private int gcd(int x, int y) {

            while (y != 0) {
                int temp = x % y;
                x = y;
                y = temp;
            }
            return x;
        }
    }
}
