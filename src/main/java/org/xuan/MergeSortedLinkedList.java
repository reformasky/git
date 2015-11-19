package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2015/11/18.
 */
public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(-1),
                current1 = l1,
                current2 = l2,
                currentMerge = result;
        while(current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                currentMerge.next = current1;
                current1 = current1.next;
            }
            else {
                currentMerge.next = current2;
                current2 = current2.next;
            }
            currentMerge = currentMerge.next;
        }

        while(current1 != null) {
            currentMerge.next = current1;
            current1 = current1.next;
            currentMerge = currentMerge.next;
        }
        while(current2 != null) {
            currentMerge.next = current2;
            current2 = current2.next;
            currentMerge = currentMerge.next;
        }
        return result.next;
    }
}
