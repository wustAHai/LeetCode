package hard;

import java.util.*;

/**
 * @author chenz at 18:57 on 2022/7/22 .
 */
public class L757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o2[1] - o1[1];
                }
            }
        });
        int c = -1;
        int d = -1;
        int cnt = 0;
        for (int i = intervals.length-1; i >=0 ; i--) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (cnt == 0){
                cnt+=2;
                c = a;
                d = a+1;
                continue;
            }
            if (c>b){
                cnt+=2;
                c = a;
                d = a+1;
            }else if (c==b){
                cnt+=1;
                c=a;
                d=b;
            }else {
                if (d>b){
                    d=c;
                    c=a;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
