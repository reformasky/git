package org.xuan;

import util.ListNode;

/**
 * Created by xzhou2 on 4/22/16.
 */
public class IsPalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean result = true;
        ListNode single = head, dou = head;
        while(dou.next != null) {
            dou = dou.next;
            if (dou.next != null) {
                dou = dou.next;
            }
            else {
                break;
            }
            single = single.next;
        }
        ListNode temp = single.next;
        temp = reverse(temp);
        dou = temp;
        while(temp != null) {
            if (temp.val != head.val) {
                result = false;
                break;
            }
            temp = temp.next;
            head = head.next;
        }
        single.next = reverse(dou);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head,
                next = curr.next, temp;

        while( next != null) {
            temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        head.next = null;
        return curr;
    }
}
