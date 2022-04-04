package easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenz at 8:32 on 2021/2/2
 */
public class JZ06 {
    public int[] reversePrint(ListNode head) {//官方题解用栈
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - i - 1] = arrayList.get(i);
        }
        return arr;
    }
}
