package mid;

/**
 * @author chenz at 20:23 on 2022/7/12 .
 */
public class L2310 {
    public int minimumNumbers(int num, int k) {
        // 1 2 3 4 5 6 7 8 9 0    10
        // 2 4 6 8 0              10
        // 3 6 9 2 5 8 1 4 7 0    30
        // 4 8 2 6 0              20
        // 5 0                    10
        // 6 2 8 4 0              30
        // 7 4 1 8 5 2 9 6 3 0    70
        // 8 6 4 2 0              40
        // 9 8 7 6 5 4 3 2 1 0    90
        if (k==0){
            return num%10 == 0 ? num/10 : -1;
        }
        int i = 1;
        int yu = num%10;
        int z = 1;
        while (z*k%10!=yu){
            z++;
            if (z>10){
                return  -1;
            }
        }
        if (z*k>num){
            return -1;
        }
        while (i*k%10!=0){
            i++;
        }
        int num10 = i*k;
        if (num%10 ==0){
            return num/num10*i;
        }
        return z+(num-z*k)/num10*i;
    }
}
