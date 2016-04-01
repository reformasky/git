package org.xuan;

import util.ListNode;

import java.util.List;

/**
 * Created by xzhou2 on 3/31/16.
 */
public class QuickSortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return help(head).head;
    }

    public Pair help(ListNode head) {
        if (head.next == null) {
            return new Pair(head, head);
        }
        ListNode curr = head.next;
        head.next = null;
        ListNode smaller = new ListNode(-1), larger = new ListNode(-1);
        ListNode currSmaller = smaller, currLarger = larger;
        boolean addToLarger = false;
        while (curr != null) {
            ListNode next = curr.next;
            int val = head.val;
            if (curr.val < val) {
                addToLarger = false;
            }
            else if (curr.val > val) {
                addToLarger = true;
            }
            else {
                addToLarger = ! addToLarger;
            }

            if (! addToLarger) {
                currSmaller.next = curr;
                currSmaller = curr;
            }
            else {
                currLarger.next = curr;
                currLarger = curr;
            }
            curr = next;
        }

        currLarger.next = null;
        currSmaller.next = null;
        Pair pre = null, post = null;
        if (smaller.next != null) {
            pre = help(smaller.next);
            if (pre.tail != head) {
                pre.tail.next = head;
            }
        }
        else {
            pre = new Pair(head, head);
        }

        if (larger.next != null) {
           post = help(larger.next);
           head.next = post.head;
        }
        else {
            post = new Pair(null, null);
        }

        return new Pair(pre.head, post.tail == null? head : post.tail) ;
    }

    class Pair{
        ListNode head, tail;
        public Pair(ListNode h, ListNode t) {
            head = h;
            tail = t;
        }
    }
}
