package easy;

public class L876 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q.next!=null){
            q = q.next.next;
            p = p.next;
        }
        return p;
    }
}
