package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenz at 23:29 on 2022/9/11 .
 */
public class L857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        if (k==1){
            return Arrays.stream(wage).min().getAsInt();
        }
        Rate[] rate = new Rate[wage.length];
        for (int i = 0; i < wage.length; i++) {
            rate[i] = new Rate((double) wage[i]/quality[i],quality[i]);
        }
        Arrays.sort(rate, new Comparator<Rate>() {
            @Override
            public int compare(Rate o1, Rate o2) {
                return o1.rate.compareTo(o2.rate);
            }
        });
        double min = Double.MAX_VALUE;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int i = 0; i < k-1; i++) {
            priorityQueue.add(rate[i].n);
            sum+=rate[i].n;
        }
        for (int i = k-1; i < wage.length; i++) {
            min=Math.min(min,(sum+rate[i].n)*rate[i].rate);
            if (rate[i].n<priorityQueue.peek()){
                sum  += rate[i].n-priorityQueue.poll();
                priorityQueue.add(rate[i].n);
            }
        }
        return min;
    }

    class Rate{
        Double rate;
        int n;

        public Rate(Double rate, int n) {
            this.rate = rate;
            this.n = n;
        }
    }
}
