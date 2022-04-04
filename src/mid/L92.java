package mid;

import easy.ListNode;

import java.util.List;

/**
 * Created by chenz at 21:23 on 2021/3/18
 */
public class L92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode();
        dummyNode.next=head;
        int counter = 0;
        ListNode p = dummyNode;
        ListNode preLeft = null;
        while (counter<right){
            if (counter+1==left){
                preLeft=p;
            }
            p=p.next;
            counter++;
        }
        ListNode sucRight = p.next;
        ListNode leftNode  = preLeft.next;
        ListNode p1 = leftNode;
        ListNode p2 = leftNode.next;
        while (p1.next!=null&&p1!=p){
            ListNode p3 = p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        leftNode.next=sucRight;
        preLeft.next=p;
        return dummyNode.next;
    }
}
