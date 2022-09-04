package mid;

/**
 * @author chenz at 20:42 on 2022/7/12 .
 */
public class L2311 {
    public int longestSubsequence(String s, int k) {
        int ans  = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='0'){
                ans++;
            }
        }
        long sum = 0;
        long n =1;
        for (int i = s.length()-1; i >=0 ; i--) {
            sum+=(s.charAt(i)-'0')*n;
            if (sum<=k&&s.charAt(i)=='1'){
                ans++;
            }
            if (sum>k){
                break;
            }
            n*=2;
        }
        return ans;
    }
}
