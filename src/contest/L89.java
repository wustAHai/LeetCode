package contest;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 22:33 on 2022/10/15 .
 */
public class L89 {
    public int countTime(String time) {
        int h =  1;
        char[] chars = time.toCharArray();
        if (chars[0]=='?'){
            if (chars[1]=='?'){
                h=24;
            }else {
                if (chars[1]-'0'<=4) {
                    h = 3;
                }else {
                    h= 2;
                }
            }
        }else if (chars[1]=='?'){
            if (chars[0]=='2'){
                h=3;
            }else {
                h=10;
            }
        }
        int m = 1;
        if (chars[3]=='?'){
            if (chars[4]=='?'){
                m=60;
            }else {
                m=6;
            }
        }else if (chars[4]=='?'){
            m=10;
        }
        return  h*m;
    }

    public int[] productQueries(int n, int[][] queries) {
        //1 2 6
        int i = Integer.bitCount(n);
        int[]power = new int[i];
        i=0;
        int t=1;
        while (n>0){
            if ((n&1)==1){
                power[i++]=t%1000000007;
            }
            n>>=1;
            t<<=1;
        }
        int[] ans = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            long l=1L;
            for (int k = queries[j][0]; k <=queries[j][1] ; k++) {
                l%=1000000007;
                l*=power[k];
            }
            ans[j]= (int) (l%1000000007);
        }
        return ans;
    }

/*    public int minimizeArrayValue(int[] nums) {
        for (int i = nums.length-1; i >=1; i--) {
            if (nums[i]>nums[i-1])
        }
        return Arrays.stream(nums).max().getAsInt();
    }*/

    public static void main(String[] args) {
        L89 l89 = new L89();
        System.out.println(Arrays.toString(l89.productQueries(919,new int[][]{{0,6}})));
    }
}
