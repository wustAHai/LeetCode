package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 21:52 on 2022/8/1 .
 */
public class L2360 {
    public int longestCycle(int[] edges) {
        int ans = -1;
        int[] visit = new int[edges.length];
        Arrays.fill(visit,-1);
        for (int i = 0; i < edges.length; i++) {
            if (edges[i]==-1){
                visit[i] = -2;
            }else if (edges[i]==i){
                visit[edges[i]] = -3;
                ans = 1;
            }else {
                if (visit[edges[i]]!=-2&&visit[edges[i]]!=-3){
                    visit[edges[i]]=0;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (visit[i]!=0){
                continue;
            }
            int l = 0;
            int temp = i;
            List<Integer> list = new ArrayList<>();
            while (visit[temp]==0){
                visit[temp]=1;
                l++;
                list.add(temp);
                temp = edges[temp];
            }
            if (temp==i){
                ans = Math.max(l,ans);
            }else {
                for (int j = 1; j < list.size(); j++) {
                    visit[list.get(j)]=0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] edges =new  int[]{4,3,3,4,7,2,3,3};
        System.out.println( new L2360().longestCycle(edges));
    }
}
