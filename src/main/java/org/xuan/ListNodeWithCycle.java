package org.xuan;

import util.ListNode;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class ListNodeWithCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode oneStep = head.next;
        if (oneStep == null) {
            return false;
        }
        ListNode twoStep = oneStep.next;
        while(twoStep != null) {
            if (oneStep == twoStep) {
                return true;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next;
            if (twoStep != null) {
                twoStep = twoStep.next;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
