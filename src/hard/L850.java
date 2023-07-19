package hard;

import java.util.*;

/**
 * @author chenz at 20:48 on 2022/9/16 .
 * <a href="https://leetcode.cn/problems/rectangle-area-ii/solution/ju-xing-mian-ji-ii-by-leetcode-solution-ulqz/">题解</a>
 */
public class L850 {
    public int rectangleArea(int[][] rectangles) {
        int mod = 1000000007;
        Set<Integer> ySet = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            ySet.add(rectangles[i][1]);
            ySet.add(rectangles[i][3]);
        }
        List<Integer> yList = new ArrayList<>(ySet);
        yList.sort(null);
        List<int[]> sweep = new ArrayList<>();
        for (int i = 0; i < rectangles.length; i++) {
            sweep.add(new int[]{rectangles[i][0],i,1});
            sweep.add(new int[]{rectangles[i][2],i,-1});
        }
        sweep.sort((a,b)->{
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }else if (a[1]!=b[1]){
                return a[1]-b[1];
            }else {
                return a[2]-b[2];
            }
        });
        int m = ySet.size();
        int[] seg = new int[m-1];
        long ans=0;
        for (int i = 0; i < sweep.size(); i++) {
            int j = i;
            while (j+1<sweep.size()&&sweep.get(j)[0]==sweep.get(j+1)[0]){
                j++;
            }
            if (j+1==sweep.size()){
                break;
            }
            for (int k = i; k <= j; k++) {
                int[] border = sweep.get(k);
                int diff = border[2];
                int low =  rectangles[border[1]][1];
                int high = rectangles[border[1]][3];
                for (int idx = 0; idx < seg.length; idx++) {
                    if (low<=yList.get(idx)&&yList.get(idx+1)<=high){
                        seg[idx]+=diff;
                    }
                }
            }
            int cover =0;
            for (int idx = 0; idx < seg.length; idx++) {
                if (seg[idx]>0){
                    cover+=yList.get(idx+1)-yList.get(idx);
                }
            }
            ans += (long) cover *(sweep.get(j+1)[0]-sweep.get(j)[0]);
            i=j;
        }
        return (int) (ans%mod);
    }
}
