package easy;

/**
 * @author chenz at 18:52 on 2022/9/1 .
 */
public class L1475 {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int temp = 0;
            for (int j = i+1; j <prices.length ; j++) {
                if (prices[j]<=prices[i]){
                    temp = prices[j];
                    break;
                }
            }
            ans[i] = prices[i]-temp;
        }
        return ans;
    }
}
