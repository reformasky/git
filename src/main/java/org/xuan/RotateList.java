package org.xuan;

import util.ListNode;

/**
 * Created by xuan on 2015/12/14.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode tail, result;
        ListNode current = head;
        while(current.next != null) {
            length++;
            current = current.next;
        }
        length++;
        if(k % length == 0) {
            return head;
        }
        tail = current;
        int steps = length -  k % length ;
        current = head;
        for(int i = 0; i < steps -1 ; i++) {
            current = current.next;
        }
        result = current.next;
        current.next = null;
        tail.next = head;
        return result;
    }
}
