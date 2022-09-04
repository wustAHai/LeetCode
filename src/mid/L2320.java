package mid;

/**
 * @author chenz at 19:44 on 2022/6/29 .
 */
public class L2320 {
    //fi = fi-1 + fi-2
    //f0 = 1 f1 = 2
    public int countHousePlacements(int n) {
        int mod = 1000000007;
        int c = fib(n);
        long ans = (long) c *c%mod;

        return (int) ans;
    }

    int fib(int n){
        int a = 1;
        int b = 2;
        if (n==0){
            return a;
        }
        if (n == 1){
            return  b;
        }
        while (n>1){
            int c = (a+b)%1000000007;
            a=b;
            b=c;
            n--;
        }
        return b;
    }

}
