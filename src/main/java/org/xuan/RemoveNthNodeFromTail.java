package org.xuan;


import util.ListNode;

public class RemoveNthNodeFromTail {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstNode, secondNode;
        firstNode = head;
        for(int i = 0; i < n; i ++) {
            if (firstNode.next != null) {
                firstNode = firstNode.next;
            }
            else {
                return head.next;
            }
        }
        secondNode = head;
        while(firstNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;
        return head;
    }
}
