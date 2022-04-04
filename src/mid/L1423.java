package mid;

import org.junit.Test;

/**
 * Created by chenz at 0:14 on 2021/2/6
 */
public class L1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        int q = cardPoints.length;
        while (k > 0) {
            sum -= cardPoints[--k];
            sum += cardPoints[--q];
            max = max > sum ? max : sum;
        }
        return max;
    }
}
