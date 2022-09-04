package lccup.spring2022;

import java.util.Arrays;

/**
 * @author chenz at 15:22 on 2022/4/16 .
 */
public class Solution1 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
           int a = gem[operation[0]]/2;
           gem[operation[0]]-=a;
           gem[operation[1]]+=a;
        }
        int max = gem[0];
        int min = gem[0];
        for (int i : gem) {
            max= Math.max(i,max);
            min = Math.min(i,min);
        }
        return  max - min;
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int ans = -1;
        int length = cookbooks.length;
        int n = 1;
        for (int i = 0; i < length; i++) {
            n*=2;
        }
        int[] cook = new int[5];
        for (int i = 1; i < n; i++) {
            int temp = i;
            int l = 0;
            int m = 0;
            int w = 0;
            Arrays.fill(cook,0);
            while (temp>0){
                if ((temp&1)==1){
                    for (int i1 = 0; i1 < cookbooks[i].length; i1++) {
                        cook[i1] += cookbooks[i][i1];
                    }
                    m+=attribute[w][0];
                    l+=attribute[w][1];
                }
                temp>>=1;
                w++;
            }
            if (check(materials,cook)) {
                if (l>=limit){
                    ans = Math.max(ans,m);
                }
            }
        }
        return ans;
    }

    boolean check(int[]m,int[] cook){
        for (int i = 0; i < m.length; i++) {
            if (m[i]<cook[i]){
                return false;
            }
        }
        return true;
    }
}
