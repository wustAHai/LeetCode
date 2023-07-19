package contest.L99;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenz at 22:30 on 2023/3/4 .
 */
public class L6312 {
    public int splitNum(int num) {
        while (num%10==0){
            num/=10;
        }
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int a = 0;
        int b = 0;
        int i = 0;
        if (chars.length%2==1){
            a = chars[0]-'0';
            i++;
        }
        for (;i<chars.length;i++){
            a*=10;
            a+=chars[i]-'0';
            i++;
            if (i<chars.length){
                b*=10;
                b+=chars[i]-'0';
            }
        }
        return a+b;
    }
    public long coloredCells(int n) {
        long l = 2*n-1;
        return  (l+1)*n-l;
    }

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o1[0]-o2[0]:o2[1]-o1[1];
            }
        });
        int[] p = new int[ranges.length];
        for (int i = 0; i < p.length; i++) {
            p[i]=i;
        }
        for (int i = 1; i < ranges.length; i++) {
           if (ranges[p[i-1]][1]>=ranges[i][0]){
               p[i]=p[i-1];
               ranges[p[i-1]][1]=Math.max(ranges[p[i-1]][1],ranges[i][1]);
           }
        }
        long l = 1;
        for (int i = 0; i < p.length; i++) {
            if (p[i]==i){
                l<<=1;
                l%=1000000007;
            }
        }
        return (int) l;
    }
}
