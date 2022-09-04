package easy;

/**
 * @author chenz at 13:49 on 2022/4/5 .
 */
public class L762 {
    public int countPrimeSetBits(int left, int right) {
       boolean[] a = new boolean[20];
        for (int i = 2; i < 20; i++) {
            a[i] = isPrime(i);
        }
        int ans =0;
        for (int i = left; i <= right ; i++) {
            if (a[Integer.bitCount(i)]){
                ans++;
            }
        }
        return ans;
    }


    boolean isPrime(int a){
        if (a==2||a==3){
            return true;
        }
        for (int i = 2; i *i<= a; i++) {
            if (a%i==0){
                return  false;
            }
        }
        return true;
    }

}
