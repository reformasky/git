package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2016/1/31.
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(-1),
                gte = new ListNode(-1);
        ListNode curr = head,
                lt_curr = lt,
                gte_curr = gte;
        while(curr != null) {
            if (curr.val < x) {
                lt_curr.next = curr;
                lt_curr = lt_curr.next;
            } else {
                gte_curr.next = curr;
                gte_curr = gte_curr.next;
            }
            curr = curr.next;
        }

        lt_curr.next = gte.next;
        return lt.next;
    }
}
