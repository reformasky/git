package org.xuan;

import util.TreeLinkNode;

/**
 * Created by xuan on 2016/2/29.
 */
public class PopulateNextRightPointerII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode curr = root;
        TreeLinkNode parent = root;
        while(curr != null) {
            TreeLinkNode left = curr.left;
            TreeLinkNode right = curr.right;
            TreeLinkNode node = null;
            if (left != null) {
                if (right != null) {
                    left.next = right;
                }
                else while(curr.next != null) {
                    node = curr.next.left;
                    if (node != null) {
                        left.next = node;
                        break;
                    }
                    node = curr.next.right;
                    if (node != null) {
                        left.next = node;
                        break;
                    }
                    curr = curr.next;
                }

            }

            if (right != null) {
                while(curr.next != null) {
                    node = curr.next.left;
                    if (node != null) {
                        right.next = node;
                        break;
                    }
                    node = curr.next.right;
                    if (node != null) {
                        right.next = node;
                        break;
                    }
                    curr = curr.next;
                }
            }

            if (curr.next != null) {
                curr = curr.next;
            }
            else {
                while(parent != null) {
                    node = parent.left;
                    if (node != null) {
                        break;
                    }
                    node = parent.right;
                    if (node != null) {
                        break;
                    }
                    parent = parent.next;
                }
                curr = node;
                parent = curr;
            }
        }
    }
}
