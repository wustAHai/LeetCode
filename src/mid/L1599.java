package mid;

/**
 * @author chenz at 18:48 on 2023/3/5 .
 */
public class L1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (runningCost>4*boardingCost){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int maxRound = 0;
        int res = 0;
        int profit = 0;
        int round = 0;
        for (int i = 0; i < customers.length; i++) {
            customers[i]+=res;
            res = 0;
            if (customers[i]>4){
                res = customers[i]-4;
            }
            profit += Math.min(customers[i],4)*boardingCost - runningCost;
            round ++;
            if (profit>max){
                max = profit;
                maxRound = round;
            }
        }
        while (res>0){
            profit+=Math.min(res,4)*boardingCost-runningCost;
            res-=Math.min(res,4);
            round++;
            if (profit>max){
                max=profit;
                maxRound=round;
            }
        }
        if (max<=0){
            return -1;
        }else {
            return maxRound;
        }

    }
}
