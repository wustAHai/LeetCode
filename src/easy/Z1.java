package easy;

import java.util.List;

/**
 * Created by chenz at 20:58 on 2021/1/29
 */
public class Z1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null) {
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        p.next = null;
        return dummyNode.next;
    }
}
