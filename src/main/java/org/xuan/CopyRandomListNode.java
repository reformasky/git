package org.xuan;

import util.RandomListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * Created by xzhou2 on 3/27/16.
 */
public class CopyRandomListNode {

    public RandomListNode copyRandomList_map(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map;
        Set<RandomListNode> processed;
        RandomListNode result = new RandomListNode(head.label);
        map = new HashMap<>();
        processed = new HashSet<>();
        map.put(head, result);
        Queue<RandomListNode> queue = new ArrayDeque<>();
        queue.add(head);
        RandomListNode currOrigin, currCopy;
        RandomListNode nextOrigin, nextCopy, randomOrigin, randomCopy;
        while(! queue.isEmpty()) {
            currOrigin = queue.remove();
            currCopy = map.get(currOrigin);
            nextOrigin = currOrigin.next;
            randomOrigin = currOrigin.random;
            if (nextOrigin != null) {
                if (map.containsKey(nextOrigin)) {
                    nextCopy = map.get(nextOrigin);
                }
                else {
                    nextCopy = new RandomListNode(nextOrigin.label);
                    map.put(nextOrigin,nextCopy);
                }
                currCopy.next = nextCopy;
                if (!processed.contains(nextOrigin)) {
                    queue.add(nextOrigin);
                }
            }
            if (randomOrigin != null) {
                if (map.containsKey(randomOrigin)) {
                    randomCopy = map.get(randomOrigin);
                }
                else {
                    randomCopy = new RandomListNode(randomOrigin.label);
                    map.put(randomOrigin, randomCopy);
                }
                currCopy.random = randomCopy;
                if (!processed.contains(randomOrigin)) {
                    queue.add(randomOrigin);
                }
            }

            processed.add(currOrigin);
        }
        return result;
    }

    /**
     * The assumption is all nodes have a pre except for the head;
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        List<RandomListNode> cache = new ArrayList<>();
        RandomListNode result = new RandomListNode(head.label);
        RandomListNode origin = head, copy = result;
        RandomListNode nextOrigin, nextCopy;
        while(origin != null) {
            cache.add(origin);
            nextOrigin = origin.next;
            if (nextOrigin != null) {
                nextCopy = new RandomListNode(nextOrigin.label);
            }
            else {
                nextCopy = null;
            }
            copy.next = nextCopy;
            copy.random = origin.random;
            origin.next = copy;
            origin = nextOrigin;
            copy = copy.next;
        }

        RandomListNode curr = result;
        while(curr != null) {
            if (curr.random != null) {
                curr.random = curr.random.next;
            }
            else {
                curr.random = null;
            }

            curr = curr.next;
        }
        curr = head;
        for(int i = 1; i < cache.size(); i++) {
            curr.next = cache.get(i);
            curr = curr.next;
        }
        curr.next = null;
        return result;
    }
}
