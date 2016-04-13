package org.xuan;

import util.ListNode;

/**
 * Created by xzhou2 on 4/11/16.
 */
public class RemoveNumberFromLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while(true) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
            if (curr == null) {
                break;
            }
        }
        return pre.next;
    }
}
