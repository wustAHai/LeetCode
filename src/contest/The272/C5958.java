package contest.The272;

/**
 * @author chenz at 10:39 on 2021/12/19 .
 */
public class C5958 {
    public long getDescentPeriods(int[] prices) {
        long  ans = prices.length ;
        long lian = 0;
        for (int i = 1; i < prices.length;i++) {
            lian = 0 ;
            while (i<prices.length&&prices[i]-prices[i-1]==-1){
                i++;
                lian++;
            }
            ans += (lian + 1) *lian/2;
        }
        return ans;
    }
}
