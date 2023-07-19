package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author chenz at 14:02 on 2022/9/12 .
 */
public class AutoX {
    public int getLengthOfWaterfallFlow(int num, int[] block) {
        int max = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        for (int i = 0; i < num; i++) {
            priorityQueue.add(new int[]{0, i});
        }
        for (int i = 0; i < block.length; i++) {
            int[] poll = priorityQueue.poll();
            max = Math.max(block[i] + poll[0], max);
            poll[0] += block[i];
            priorityQueue.add(poll);
        }
        return max;
    }

    public double[] honeyQuotes(int[][] handle) {
        List<Double> list = new ArrayList<>();
        int sum = 0;
        int sum2 = 0;
        int n = 0;

        for (int[] ints : handle) {
            if (ints[0] == 1) {
                sum += ints[1];
                sum2 += ints[1] * ints[1];
                n++;
            } else if (ints[0] == 2) {
                n--;
                sum -= ints[1];
                sum2 -= ints[1] * ints[1];
            } else if (ints[0] == 3) {
                if (n == 0) {
                    list.add(-1.0);
                } else {
                    list.add((double) sum / n);
                }
            } else {
                if (n == 0) {
                    list.add(-1.0);
                } else {
                    list.add(((double) sum2 - (double)sum * sum/n)/n) ;
                }
            }
        }
        double[] doubles = new double[list.size()];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = list.get(i);
        }
        return doubles;
    }
}
