package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2016/1/31.
 */
public class ReverseLinkedListInRange {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //linkedList length is guranteed to be larger than n;

        ListNode pre, current, next, temp, tail;
        current = head;
        pre = new ListNode(-1);
        pre.next = head;
        for (int i = 1; i < m; i++) {
            current = current.next;
            pre = pre.next;
        }

        next = current.next;
        tail = current;
        for(int i = m; i < n; i++) {
            temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        pre.next = current;
        tail.next = next;
        if (m == 1) {
            return pre.next;
        }
        else {
            return head;
        }
    }
}
