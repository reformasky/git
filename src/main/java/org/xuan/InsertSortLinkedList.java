package org.xuan;

import util.ListNode;

/**
 * Created by xzhou2 on 3/29/16.
 */
public class InsertSortLinkedList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(Integer.MIN_VALUE);
        insertSort(result, head);
        return result.next;
    }

    private void insertSort(ListNode sorted, ListNode curr) {
        ListNode next = curr.next;
        curr.next = null;
        ListNode temp = sorted;
        while(temp != null) {
            if (temp.next != null && temp.next.val > curr.val) {
                curr.next = temp.next;
                temp.next = curr;
                break;
            }
            else if (temp.next == null) {
                temp.next = curr;
                break;
            }
            temp = temp.next;
        }

        if (next != null) {
            insertSort(sorted, next);
        }
    }
}
