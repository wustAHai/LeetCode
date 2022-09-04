package top500;

/**
 * @author chenz at 20:21 on 2022/7/15 .
 */
public class T395至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        if (k==1){
            return s.length();
        }
        int m = s.length();
        int ret = 0 ;
        for (int t = 1; t <= 26; t++) {
            int l  = 0;
            int r =  0;
            int tot = 0;
            int less = 0;
            int[] cnt = new int[26];
            while (r < m){
                int index = s.charAt(r) - 'a';
                cnt[index]++;
                if (cnt[index] == 1){
                    tot++;
                    less++;
                }
                if (cnt[index]==k){
                    less--;
                }
                while (tot>t){
                    index = s.charAt(l) - 'a';
                    cnt[index] --;
                    if (cnt[index] == k-1){
                        less++;
                    }
                    if (cnt[index] == 0){
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0){
                    ret = Math.max(ret,r-l+1);
                }
                r++;
            }
        }
        return ret;
    }
}
