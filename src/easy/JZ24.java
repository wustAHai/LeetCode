package easy;

/**
 * Created by chenz at 11:51 on 2021/2/5
 */
public class JZ24 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        if (head != null) {
            ListNode p = head.next;
            head.next = null;
            dummyNode.next = head;
            while (p != null) {
                ListNode temp = p.next;
                p.next = dummyNode.next;
                dummyNode.next = p;
                p = temp;
            }
        }
        return dummyNode.next;
    }
}
