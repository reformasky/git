package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2015/11/24.
 */
public class SwapNode {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, curr = head.next, next = head.next.next;
        ListNode result = new ListNode(-1);
        do {
            if (pre == head) {
                result.next = curr;
            }
            curr.next = pre;
            if(next != null && next.next != null) {
                pre.next = next.next;
            }
            else {
                pre.next = next;
                return result.next;
            }

            pre = next;
            curr = next.next;
            next = curr.next;
        } while(true);
    }
}
