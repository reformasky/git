package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2016/3/22.
 */
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode result;
        ListNode headForA = headA;
        while(headA.next != null) {
            headA = headA.next;
        }
        headA.next = headForA;
        headForA = headA;

        ListNode oneStep = headB, twoStep = headB;
        while(twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                break;
            }
        }
        if (twoStep.next == null || twoStep.next.next == null) {
            headForA.next = null;
            return null;
        }
        oneStep = headB;
        while(oneStep != twoStep) {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
        }
        result = oneStep;
        headForA.next = null;
        return result;
    }
}
