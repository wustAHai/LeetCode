package top500;

import easy.ListNode;

public class T2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode sum  = new ListNode();
        ListNode k = sum;
        int j = 0;
        while (p!=null&&q!=null){
            int i = p.val+q.val+j;
            j=i/10;
            i=i%10;
            k.next = new ListNode(i);
            k=k.next;
            p=p.next;
            q=q.next;
        }
        if (p==null){
            p=q;
        }
        while (p!=null){
            int i = p.val+j;
            j=i/10;
            i=i%10;
            k.next = new ListNode(i);
            k=k.next;
            p=p.next;
        }
        if (j!=0){
            k.next = new ListNode(j);
        }
        return sum.next;
    }
}
