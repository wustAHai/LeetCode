package hard;

/**
 * @author chenz at 12:04 on 2022/8/28 .
 */
public class L793 {
    public int preimageSizeFZF(int k) {
        return (int) (help(k+1)-help(k));
    }

    long help(int k){
        long r = 5L*k;
        long l = 0;
        while (l<=r){
            long mid = (l+r)/2;
            if (zeta(mid)<k){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return l;
    }
   long zeta(long n){
        long sum =0;
        while (n>0){
            sum+=n/5;
            n/=5;
        }
        return sum;
   }

}
