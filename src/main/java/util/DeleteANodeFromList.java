package util;

/**
 * Created by xzhou2 on 4/26/16.
 */
public class DeleteANodeFromList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
