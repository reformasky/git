package org.xuan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 4/28/16.
 */
public class MaxSlidingWindow {
    class Pair{
        int val;
        int index;
        public Pair(int v, int i) {
            val = v;
            index = i;
        }
    }

    public int[] maxSlidingWindowLgnk(int[] nums, int k) {
        int[] result = new int[nums.length -  k + 1];
        if(k < 1) {
            result[0] = 1;
            for(int i = 1; i < nums.length; i++) {
                result[i] = nums[i-1];
            }
            return nums;
        }
        if (k == 1) {
            return nums;
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((p, q) -> -p.val + q.val);
        for(int i = 0; i < k; i++) {
            queue.offer(new Pair(nums[i], i));
        }
        result[0] = queue.peek().val;
        int index = 1;
        for(int i = k; i < nums.length; i++) {
            queue.offer(new Pair(nums[i], i));
            while (queue.peek().index < (i - k + 1)) {
                queue.poll();
            }
            result[index++] = queue.peek().val;
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length -  k + 1];
        if(k < 1) {
            result[0] = 1;
            for(int i = 1; i < nums.length; i++) {
                result[i] = nums[i-1];
            }
            return nums;
        }
        if (k == 1) {
            return nums;
        }

        Deque<Pair> deque = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            int v = nums[i];
            while(!deque.isEmpty() &&deque.getLast().val <= v) {
                deque.removeLast();
            }
            deque.addLast(new Pair(v, i));
        }
        result[0] = deque.getFirst().val;
        for(int i = k; i < nums.length;i++) {
            int v = nums[i];
            while ((!deque.isEmpty() && deque.getFirst().index < (i - k + 1))) {
                deque.removeFirst();
            }
            while ((!deque.isEmpty() && deque.getLast().val <= v)) {
                deque.removeLast();
            }
            deque.addLast(new Pair(v, i));
            result[i - k + 1] = deque.getFirst().val;
        }
        return result;
    }
}
