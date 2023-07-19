package mid;

/**
 * @author chenz at 19:02 on 2022/9/28 .
 */
public class  KthMagicNumber{
    public int getKthMagicNumber(int k) {
        int pre = 1;
        int sum = 0;
        int num = 0;
        while (k>sum){
            sum+=pre;
            pre*=3;
            num++;
        }
        num--;
        sum-=pre/3;
        int offset = k-sum;
        // 3 5 7
        //     0  1    num+1
        //     1
        //     2  2*num
        int num3 = num;
        int num5 = 0;
        int num7 = 0;
        for (int i = 1; i < offset; i++) {

            //3/5 5/7  3/5* 7/5
            if (num3>0&&num7>0){
                num3--;
                num7--;
                num5+=2;
                continue;
            }
            if (num5>0){
                num5--;
                num7++;
                continue;
            }
            if (num3>0){
                num5++;
                num3--;
            }
        }
        return  fun(num3,num5,num7);
    }

    private int fun(int num3, int num5, int num7) {
        int ans = 1;
        for (int i = 0; i < num3; i++) {
            ans*=3;
        }
        for (int i = 0; i < num5; i++) {
            ans*=5;
        }
        for (int i = 0; i < num7; i++) {
            ans*=7;
        }
        return ans;
    }

    public static void main(String[] args) {
        KthMagicNumber kthMagicNumber = new KthMagicNumber();
        System.out.println(kthMagicNumber.getKthMagicNumber(7));
    }
}
