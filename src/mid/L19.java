package mid;

import easy.ListNode;

public class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode p = dummyNode;
        ListNode q = head;
        while (n>0){
            q = q.next;
            n--;
        }
        while (q!=null){
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return dummyNode.next;
    }
}
