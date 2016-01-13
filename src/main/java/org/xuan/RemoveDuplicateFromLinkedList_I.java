package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2016/1/12.
 */
public class RemoveDuplicateFromLinkedList_I {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        int currentValue;

        while (head != null) {
            currentValue = head.val;
            currentNode.next = head;
            currentNode = currentNode.next;
            while (head.next != null && head.next.val == currentValue) {
                head = head.next;
            }
            head = head.next;
        }

        currentNode.next = null;
        return result.next;
    }
}
