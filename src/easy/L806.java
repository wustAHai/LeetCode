package easy;

/**
 * @author chenz at 21:42 on 2022/4/12 .
 */
public class L806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        ans[0] = 1;
        int n = s.length();
        for (int i = 0; i <n ; i++) {
            if (ans[1]+widths[s.charAt(i)-'a']>100){
                ans[0]++;
                ans[1]=widths[s.charAt(i)-'a'];
            }else {
                ans[1]+=widths[s.charAt(i)-'a'];
            }
        }
        return ans;
    }
}
