package org.xuan;

import util.ListNode;

import java.util.List;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode oneStep = head;
        ListNode twoStep = head;
        ListNode temp;
        while(twoStep.next != null) {
            temp = oneStep;
            twoStep = twoStep.next;
            twoStep = twoStep.next;
            oneStep = oneStep.next;
            if (twoStep == null) {
                temp.next = null;
                break;
            }
        }
        if (twoStep != null) {
            temp = oneStep;
            oneStep = oneStep.next;
            temp.next = null;
        }
        ListNode reverse = reverse(oneStep);
        merge(head, reverse);
    }

    void merge(ListNode head, ListNode reverse) {
        while (head != null && reverse != null) {
            ListNode temp = head.next;
            ListNode temp2 = reverse.next;
            head.next = reverse;
            reverse.next = temp;
            head = temp;
            reverse = temp2;
        }
    }

    ListNode reverse(ListNode node) {
        ListNode curr = node, next = node.next;
        while (next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        node.next = null;
        return curr;
    }
}
