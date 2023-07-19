package contest;

/**
 * @author chenz at 10:23 on 2022/10/23 .
 */
public class C316 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = func(event1[0]);
        int e1 = func(event1[1]);
        int s2 = func(event2[0]);
        int e2 = func(event2[1]);
        return e1 < s2 || s1 > e2;
    }

    int func(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
    }

        public int subarrayGCD(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0]==k?1:0;
        for (int i = 1; i < nums.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new C316().gcd(6,4));
        System.out.println(4%6);
    }
    int gcd(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a%b;
        }
        return b;
    }
}
