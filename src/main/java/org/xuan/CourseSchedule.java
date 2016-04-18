package org.xuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 4/12/16.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        boolean[] finished = new boolean[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for(int[] p : prerequisites){
            int from = p[0];
            int to = p[1];
            inDegree[to]++;
            edges.get(from).add(to);
        }

        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(! queue.isEmpty()) {
            int from = queue.remove();
            finished[from] = true;
            count++;
            for(int to : edges.get(from)) {
                if (finished[to]) {
                    return false;
                }
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.add(to);
                }
            }
        }
        return count == numCourses;
    }
}
