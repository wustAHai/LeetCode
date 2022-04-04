package easy;

/**
 * Created by chenz at 10:55 on 2021/2/5
 */
public class JZ18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return dummyNode.next;
    }
}
