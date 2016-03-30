package org.xuan;

import util.ListNode;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;

        ListNode next = curr.next;
        while(next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        head.next = null;
        return curr;
    }
}
