package mid;

public class L1969 {


    //(a*b) mod c = ( a mod c * b mod c) mod c
    public static final int MOD = 1000000007;
    public int minNonZeroProduct(int p) {
        long a = (1L<<p) -1;
        long b = a - 1;
        long c = b/2;
        return  (int)((a%MOD)*power(b%MOD,c)%MOD);
    }
    public int power(long a, long b){
        long ans = 1l;
        long temp = a;
        while (b>0){
            if (b%2==1){
                ans=ans*temp%MOD;
            }
            temp = temp*temp%MOD;
            b=b/2;
        }
        return (int)ans;
    }

}
