package easy;

/**
 * @author chenz at 19:39 on 2022/6/30 .
 */
public class L1175 {
    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                count++;
        }
        n -= count;
        return (int) (jiechen(n)*jiechen(count)%1000000007);
    }
    long jiechen(int n){
        if (n == 0){
            return  1;
        }
        long i = 1;
        while (n>0){
            i*=n;
            i%=1000000007;
            n--;
        }
        return i;
    }
    boolean isPrime(int n){
        if (n==2 || n == 3){
            return true;
        }
        if (n>=4){
            for (int i = 2; i*i <=n ; i++) {
                if (n%i==0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
