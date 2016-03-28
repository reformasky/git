package org.xuan;

import util.ListNode;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class LinkedListWithCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode oneStep, twoStep;
        if (head == null) {
            return null;
        }
        oneStep = head.next;
        if (oneStep == null) {
            return null;
        }
        twoStep = head.next.next;
        if (twoStep == null) {
            return null;
        }

        while(oneStep != twoStep) {
            oneStep = oneStep.next;
            if (twoStep == null) {
                return null;
            }
            twoStep = twoStep.next;
            if (twoStep == null) {
                return null;
            }
            twoStep = twoStep.next;
        }

        oneStep = head;
        while(oneStep != twoStep) {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
        }
        return oneStep;
    }
}
