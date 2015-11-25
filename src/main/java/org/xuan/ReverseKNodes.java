package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2015/11/23.
 */
public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode[] temp = reverse(head, k);
        ListNode result = temp[0];
        while(temp[1].next != null) {
            ListNode tempNode = temp[1];
            temp = reverse(temp[1].next, k);
            tempNode.next = temp[0];
        }
        return result;
    }

    private ListNode[] reverse(ListNode head, int k) {
        ListNode previous = null, current=head, next;
        ListNode result_h = head, result_t = head;
        for(int i = 0; i < k; i++) {
            if (result_t != null) {
                previous = result_t;
                result_t = result_t.next;
            }
            else {
                previous.next = null;
                return new ListNode[]{head, previous};
            }

        }
        previous = null;
        next = current.next;
        while(next != result_t) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        head.next = result_t;
        return new ListNode[] {current, head};

    }
}
