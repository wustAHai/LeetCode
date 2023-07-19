package mid;

import easy.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenz at 19:35 on 2022/10/12 .
 */
public class L817 {
    public int numComponents(ListNode head, int[] nums) {
        int[] ints = new int[10000];
        int i = 0;
        while (head!=null){
            ints[head.val]=i++;
            head=head.next;
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            nums[i1]=ints[nums[i1]];
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int j = 0; j < nums.length;) {
            int p=j+1;
            while (p<nums.length&&nums[p]-nums[p-1]==1){
                p++;
            }
            ans++;
            j=p;
        }
        return ans;
    }
}

