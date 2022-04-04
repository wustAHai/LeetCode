package mid;

import easy.ListNode;

/**
 * Created by chenz at 12:18 on 2021/3/25
 */
public class L82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummyNode = new ListNode();
        ListNode p  = head;
        ListNode tou = dummyNode;
        int  k=head.val-1;
        ListNode q ;
        while (p!=null){
            if (p.val==k){
                p=p.next;
                continue;
            }
            q=p.next;
            if (q!=null){
                if (p.val==q.val){
                    k=p.val;
                }else {
                    tou.next=p;
                    tou=tou.next;
                }
            }else {
                tou.next=p;
                tou=tou.next;
            }
            p=p.next;
        }
        tou.next=null;
        return dummyNode.next;
    }
}
