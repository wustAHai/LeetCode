package contest.Th75;

/**
 * @author chenz at 21:54 on 2022/4/2 .
 */
public class Solution {

    public int minBitFlips(int start, int goal) {
        int[] a = new int[33];
        int[] b = new int[33];
        int i=0;
        while (start>0){
            a[i] = start&1;
            start/=2;
            i++;
        }
        i=0;
        while (goal>0){
            b[i] = goal&1;
            goal/=2;
            i++;
        }
        i = 0;
        for (int j = 0; j < 33; j++) {
            if (a[j]!=b[j]){
                i++;
            }
        }
        return i;
     }

    public int triangularSum(int[] nums) {
        int n = nums.length;
        while (n>1){
            for (int i = 0; i < n-1; i++) {
                nums[i] = (nums[i]+nums[i+1])%10;
            }
            n--;
        }
        return nums[0];
    }

    public long numberOfWays(String s) {
        int n = s.length();
        int num0 = 0;
        int num1 = 0;
        int[] temp= new int[n];
        for (int i = 0; i < n; i++) {
            if ('0'==s.charAt(i)){
                temp[i]=num1;
                num0++;
            }else {
                temp[i]=num0;
                num1++;
            }
        }
        long ans  = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='0'){
                ans += (long) temp[i] *(num1-temp[i]);
            }else {
                ans+= (long) temp[i] *(num0-temp[i]);
            }
        }
        return ans;
    }

    public long sumScores(String s) {
        long ans = s.length();
        int[] ints = zFunc1(s);
        for (int anInt : ints) {
            ans+=anInt;
        }
        return ans;
    }
    public static int[] zFunc1(String str){
        int length = str.length();
        int[] z = new int[length];
        int l=0;
        int r=0;
        //l->r  = 0->r-l  i->r =i-l->r-l
        for (int i = 1; i < length; i++) {
            if (i>r){
                while (i+z[i]<length&&str.charAt(i+z[i])==str.charAt(z[i])){
                    z[i]++;
                }
            }else {
                z[i] = Math.min(z[i-l],r-i+1);
                if (z[i-l]>=r-i+1){
                    while (i+z[i]<length&&str.charAt(i+z[i])==str.charAt(z[i])){
                        z[i]++;
                    }
                }
            }
            if (z[i]+i-1>r){
                l=i;
                r=z[i]+i-1;
            }
        }
        return z;
    }
}
