package org.xuan;

import util.ListNode;
import util.TreeNode;

/**
 * Created by xuan on 2016/2/27.
 */
public class SortedListToBST {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        return sortedListToBST(0, length(head) - 1);
    }

    private TreeNode sortedListToBST(int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin)/2;
        TreeNode left = sortedListToBST(begin, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    private int length(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
}
