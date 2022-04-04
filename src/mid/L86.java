package mid;

import easy.ListNode;

/**
 * Created by chenz at 15:52 on 2021/1/3
 */
public class L86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode();
        ListNode dummyNode1 = new ListNode();
        ListNode res = dummyNode;
        ListNode res1 = dummyNode1;
        while (head != null) {
            if (head.val < x) {
                dummyNode.next = head;
                dummyNode = dummyNode.next;
            } else {
                dummyNode1.next = head;
                dummyNode1 = dummyNode1.next;
            }
            head = head.next;
        }
        dummyNode1.next = null;
        dummyNode.next = res1.next;
        return res.next;
    }
}
