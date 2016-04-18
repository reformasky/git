package org.xuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 4/13/16.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        int index = 0;
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        int[] inDegree = new int[numCourses];
        for(int[] p : prerequisites) {
            int f = p[0];
            int t = p[1];
            inDegree[t]++;
            edges.get(f).add(t);
        }
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(! queue.isEmpty()) {
            int from = queue.remove();
            result[index++] = from;
            visited[from] = true;
            for(int t : edges.get(from)) {
                if (visited[t]) {
                    return new int[0];
                }
                inDegree[t] = inDegree[t] - 1;
                if (inDegree[t] == 0) {
                    queue.add(t);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

    enum Status {
        NEW,
        VISITING,
        VISITED
    }
    List<List<Integer>> adj;
    int[] res;
    Status[] visited;
    int rc;
    boolean cycle = false;

    public int[] findOrder_1(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        rc = 0;
        if (numCourses == 0) return res;
        visited = new Status[numCourses];
        buildAdjacencyList(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) topoSort(i);
        return cycle ? new int[0] : res;
    }

    void topoSort(int cur) {
        if (visited[cur] == Status.VISITED || cycle) return;
        if (visited[cur] == Status.VISITING) {
            cycle = true;
            return;
        }
        visited[cur] = Status.VISITING;
        for (int i = 0; i < adj.get(cur).size(); i++) {
            if (cycle) return;
            topoSort(adj.get(cur).get(i));
        }
        res[rc++] = cur;
        visited[cur] = Status.VISITED;
    }

    void buildAdjacencyList(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
    }
}
