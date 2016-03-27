package org.xuan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 3/26/16.
 */
public class LRUCache {
    class ListNode{
        int value;
        int key;
        ListNode pre;
        ListNode next;

        ListNode(int k, int v) {
            this.value = v;
            this.key = k;
        }

        ListNode remove() {
            pre.next = this.next;
            next.pre = this.pre;
            return this;
        }

        void addNext(ListNode node) {
            next.pre = node;
            node.next = next;
            next = node;
            node.pre = this;

        }

        ListNode removeBefore() {
            ListNode node = pre;
            pre = pre.pre;
            pre.next  = this;
            return node;
        }
    }
    Map<Integer, ListNode> map;
    int size;
    int capacity;
    ListNode head;
    ListNode tail;


    public LRUCache(int capacity) {
        if (capacity > 0) {
            map = new HashMap<>(capacity);
            this.size = 0;
            this.capacity = capacity;
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.pre = head;
        }
    }

    public int get(int key) {
        if (capacity <= 0) {
            return -1;
        }
        if (map.containsKey(key)) {
            ListNode node = map.get(key).remove();
            head.addNext(node);
            return node.value;
        }
        else {
            return  -1;
        }

    }

    public void set(int key, int value) {
        if(capacity<= 0) {
            return;
        }
        if (map.containsKey(key)) {
            ListNode node = map.get(key).remove();
            node.value = value;
            head.addNext(node);
        }
        else {
            ListNode node = new ListNode(key,value);
            head.addNext(node);
            map.put(key, node);
            if (size < capacity) {
                size++;
            }
            else {
                ListNode listNode = tail.removeBefore();
                map.remove(listNode.key);
            }
        }
    }
}
