package org.xuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xzhou2 on 5/26/16.
 */
public class MinHeightTree {

    List<Integer>[] graph;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] pre = new int[n];

        bfs(0, visited, dist, pre);
        int max = -1;
        int src = -1;
        for(int i = 0; i < n; i++) {
            if (dist[i] > max) {
                src = i;
                max = dist[i];
            }
        }
        Arrays.fill(visited, false);
        bfs(src, visited, dist, pre);
        max = -1;
        int des = -1;
        for(int i = 0; i < n; i++) {
            if (dist[i] > max) {
                des = i;
                max = dist[i];
            }
        }
        List<Integer> cache = new ArrayList<>();
        while(des != -1) {
            cache.add(des);
            des = pre[des];
        }

        int len = cache.size();
        if (len % 2 == 0) {
            return Arrays.asList(cache.get(len/2), cache.get(len/2 - 1));
        }
        else {
            return Arrays.asList(cache.get(len/2));
        }
    }

    private void bfs(int src, boolean[] visited, int[] dist, int[] pre) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[src] = true;
        dist[src] = 0;
        pre[src] = -1;
        queue.offer(src);

        while(! queue.isEmpty()) {
            int curr = queue.poll();
            for(Integer i : graph[curr]) {
                if (!visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[curr] + 1;
                    pre[i] = curr;
                    queue.offer(i);
                }
            }
        }
    }

}
