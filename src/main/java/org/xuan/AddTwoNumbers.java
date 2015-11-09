package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2015/11/8.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode preNode = null;
        ListNode currentNode;
        int carryOver = 0;
        int currentValue;

        while (l1 != null && l2 != null) {
            currentValue = (l1.val + l2.val + carryOver) % 10;
            carryOver = (l1.val + l2.val + carryOver) / 10;
            currentNode = new ListNode(currentValue);
            if (preNode == null) {
                preNode = currentNode;
                result = preNode;
            }
            else {
                preNode.next = currentNode;
                preNode = currentNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            currentValue = (l1.val + carryOver) % 10;
            carryOver = (l1.val + carryOver) / 10;
            currentNode = new ListNode(currentValue);
            if (preNode == null) {
                preNode = currentNode;
                result = preNode;
            }
            else {
                preNode.next = currentNode;
                preNode = currentNode;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            currentValue = (l2.val + carryOver) % 10;
            carryOver = (l2.val + carryOver) / 10;
            currentNode = new ListNode(currentValue);
            if (preNode == null) {
                preNode = currentNode;
                result = preNode;
            }
            else {
                preNode.next = currentNode;
                preNode = currentNode;
            }
            l2 = l2.next;
        }

        //It is impossible that l1 & l2 are both null and carryOver is not 0; so do not need to do null checking
        if (carryOver != 0) {
            currentNode = new ListNode(carryOver);
            preNode.next = currentNode;
        }
        return result;
    }
}
