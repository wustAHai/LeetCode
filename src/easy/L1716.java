package easy;

/**
 * @author chenz at 9:56 on 2022/1/15 .
 */
public class L1716 {
    public int totalMoney(int n) {
        int a = n/7;
        int b = n%7;
        return  28*a+ (a-1)*a/2*7 + (a+1)*b+(b-1)*b/2;
    }
}
