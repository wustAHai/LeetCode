package mid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author chenz at 16:45 on 2023/1/2 .
 */
public class L1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        PriorityQueue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int[] order : orders) {
            //buy
            if (order[2]==0){
                while (!sell.isEmpty()&&sell.peek()[0]<=order[0]){
                    int i = sell.peek()[1];
                    if (order[1]> i){
                        order[1]-= i;
                        sell.poll();
                    }else if (order[1] == i){
                        sell.poll();
                        order[1]-=i;
                        break;
                    }else {
                        sell.peek()[1]-=order[1];
                        order[1]=0;
                        break;
                    }
                }
                if (order[1]>0){
                    buy.add(order);
                }
            }else {
                while (!buy.isEmpty()&&buy.peek()[0]>=order[0]){
                    int i = buy.peek()[1];
                    if (order[1]> i){
                        order[1]-= i;
                        buy.poll();
                    }else if (order[1] == i){
                        buy.poll();
                        order[1]-=i;
                        break;
                    }else {
                        buy.peek()[1]-=order[1];
                        order[1]=0;
                        break;
                    }
                }
                if (order[1]>0){
                    sell.add(order);
                }
            }
        }
        long sum = 0L;
        for (int[] ints : buy) {
            sum+=ints[1];
        }
        for (int[] ints : sell) {
            sum+=ints[1];
        }
        return (int) (sum%1000000007);
    }
}
