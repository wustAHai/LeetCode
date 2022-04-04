package easy;

/**
 * @author chenz at 21:35 on 2021/12/17 .
 */
public class L1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int left = numBottles/numExchange;
        ans += left;
        left = numBottles%numExchange + left;
        while (left >= numExchange){
           int  add=   left/numExchange;
            ans += add;
            left = add + left%numExchange;
        }

        return ans;
    }
}
