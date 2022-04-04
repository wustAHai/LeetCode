package contest.The47;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Created by chenz at 22:55 on 2021/3/6
 */
public class L5682 {
    public int beautySum(String s) {
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            int [] src = new int [26];
            int max=0;
            for (int j = i; j < s.length(); j++) {
                src[s.charAt(j)-'a']++;
                max=Math.max(src[s.charAt(j)-'a'],max);
                ans+= max-findMin(src);
            }
        }
        return  ans;
    }

    private int findMin(int[] src) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < src.length; i++) {
            if (src[i]!=0){
                min=Math.min(min,src[i]);
            }
        }
        return min;
    }
}
