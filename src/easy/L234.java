package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class L234 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            arrayList1.add(0, head.val);
            head = head.next;
        }
        return arrayList.equals(arrayList1);
    }
}
