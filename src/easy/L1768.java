package easy;

/**
 * @author chenz at 9:57 on 2022/10/23 .
 */
public class L1768 {
    public String mergeAlternately(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        char[] ans = new char[chs1.length+chs2.length];
        int i = 0;
        int p = 0;
        int q = 0;
        while (p<chs1.length&&q<chs2.length){
            if ((i&1)==0){
                ans[i++]=chs1[p++];
            }else {
                ans[i++]=chs2[q++];
            }
        }
        while (p<chs1.length){
            ans[i++] = chs1[p++];
        }
        while (q<chs2.length){
            ans[i++] = chs2[q++];
        }
        return new String(ans);
    }
    // 0 2 2 2 4 13  13  14 28 35
}
