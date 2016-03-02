package org.xuan;

import util.TreeLinkNode;

/**
 * Created by xuan on 2016/2/29.
 */
public class PopulateNextRightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode curr = root;
        TreeLinkNode parent = root;
        while(curr != null) {
            if (curr.left != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
            }
            if (curr.next != null) {
                curr = curr.next;
            }
            else {
                curr = parent.left;
                parent = curr;
            }
        }
    }
}
