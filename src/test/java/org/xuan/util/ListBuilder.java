package org.xuan.util;

import util.ListNode;

/**
 * Created by xuan on 2015/11/8.
 */
public class ListBuilder {
    private ListNode head;
    private ListNode tail;
    public ListBuilder(int val) {
        head = new ListNode(val);
        tail = head;
    }

    public ListBuilder add(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        return this;
    }

    public ListNode build() {
        return head;
    }
}
