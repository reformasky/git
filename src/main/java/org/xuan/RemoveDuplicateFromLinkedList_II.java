package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2016/1/12.
 */
public class RemoveDuplicateFromLinkedList_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        int currentValue;
        while(head != null) {
            currentValue = head.val;
            if (head.next == null || head.next.val != currentValue) {
                currentNode.next = head;
                currentNode = currentNode.next;
            }
            else while (head.next != null && head.next.val == currentValue) {
                head = head.next;
            }
            head = head.next;
        }
        return result.next;
    }
}
