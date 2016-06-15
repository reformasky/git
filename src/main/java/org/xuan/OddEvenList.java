package org.xuan;

import util.ListNode;

/**
 * Created by xzhou2 on 6/13/16.
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode odd = node, even = node.next;
        ListNode currOdd = odd, currEven = even;
        boolean isOdd = true;
        ListNode curr = even;
        while(curr.next != null) {
            if (isOdd) {
                currOdd.next = curr.next;
                currOdd = currOdd.next;
            }
            else {
                currEven.next = curr.next;
                currEven = currEven.next;
            }
            curr = curr.next;
            isOdd = !isOdd;
        }
        currOdd.next = even;
        currEven.next = null;
        return odd;
    }
}
