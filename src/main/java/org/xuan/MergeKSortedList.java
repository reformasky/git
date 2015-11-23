package org.xuan;

import util.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xuan on 2015/11/20.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,new ListNodeComparator());
        for(ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;
        ListNode polledNode;
        while(!pq.isEmpty()) {
            polledNode = pq.poll();
            currentNode.next = polledNode;
            currentNode = polledNode;
            if (polledNode.next != null) {
                pq.add(polledNode.next);
            }
        }
        return result.next;
    }

    class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                throw new IllegalArgumentException("Comparator can not compare null ListNode");
            }
            return l1.val - l2.val;
        }
    }
}
