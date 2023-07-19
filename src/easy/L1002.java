package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 23:07 on 2022/10/19 .
 */
public class L1002 {
    public List<String> commonChars(String[] words) {
        int[]cnt = new int[26];
        char[] chars1 = words[0].toCharArray();
        for (char c : chars1) {
            ++cnt[c-'a'];
        }
        int[] tmp = new int[26];
        for (int i = 1; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char aChar : chars) {
                ++tmp[aChar-'a'];
            }
            for (int j = 0; j < tmp.length; j++) {
                cnt[j] = Math.min(tmp[j],cnt[j]);
            }
            Arrays.fill(tmp,0);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]>0){
                list.add(((char)('a'+i))+"");
                --cnt[i];
            }
        }
        return list;
    }
    public int getDecimalValue(ListNode head) {
        int i = 0;
        while (head!=null){
            i<<=1;
            i+=head.val;
            head=head.next;
        }
        return i;
    }
    // 13  14  32 5 34 28 2 13 2
     //    (34^2) *32 >> 0
    //

}
