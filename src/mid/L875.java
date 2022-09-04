package mid;

import java.util.Random;

/**
 * @author chenz at 20:45 on 2022/6/8 .
 */
public class L875 {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi = piles[0];
        for (int i = 1; i <piles.length ; i++) {
            hi = Math.max(piles[i],hi);
        }
        int mid =0 ;
        while (lo<hi){
            mid = (lo+hi)/2;
            int sum = 0;
            for (int pile : piles) {
                sum += pile/mid+ (pile%mid>0?1:0);
            }
            if (sum >h){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        L875 l875 = new L875();
        System.out.println(l875.minEatingSpeed(piles, h));
    }
}
