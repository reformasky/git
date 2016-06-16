package org.xuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 6/15/16.
 */
public class Twitter {
    Map<Integer, Set<Integer>> friends;
    //counter:id
    Map<Integer, Deque<Integer[]>> feeds;
    final int cap = 10;
    int counter = 0;
    /** Initialize your data structure here. */
    public Twitter() {
        friends = new HashMap<>();
        feeds = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!feeds.containsKey(userId)) {
            feeds.put(userId, new ArrayDeque<>(cap));
        }
        Deque<Integer[]> queue = feeds.get(userId);
        if (queue.size() >= cap) {
            queue.removeFirst();
        }
        queue.addLast(new Integer[]{counter++, tweetId});

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Deque<Integer[]>> queues = new ArrayList<>();
        Deque<Integer[]> feed = feeds.get(userId);
        int totalSize = 0;
        if(feed != null) {
            queues.add(new ArrayDeque<>(feed));
            totalSize += feed.size();
        }

        Set<Integer> followees = friends.get(userId);
        if (followees != null) {
            for(Integer i : followees) {
                feed = feeds.get(i);
                if (feed != null) {
                    queues.add(new ArrayDeque<>(feed));
                    totalSize += feed.size();
                }
            }
        }

        PriorityQueue<Integer[]> cache = new PriorityQueue<>((p, q) ->(q[0] - p[0]));

        for(int i = 0; i < queues.size();i++) {
            Integer[]ele = queues.get(i).removeLast();
            cache.add(new Integer[]{ele[0],ele[1], i});
        }
        int size = Math.min(cap, totalSize);
        List<Integer> result = new ArrayList<>(size);
        while(result.size() < size) {
            Integer[] curr = cache.poll();
            result.add(curr[1]);
            if (!queues.get(curr[2]).isEmpty()) {
                Integer[] ele = queues.get(curr[2]).removeLast();
                cache.offer(new Integer[]{ele[0], ele[1], curr[2]});
            }
        }
        return result;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!friends.containsKey(followerId)) {
            friends.put(followerId, new HashSet<>());
        }
        friends.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (friends.containsKey(followerId)) {
            friends.get(followerId).remove(followeeId);
        }
    }
}