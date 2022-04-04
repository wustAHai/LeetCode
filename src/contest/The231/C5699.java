package contest.The231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenz at 11:13 on 2021/3/7
 */
public class C5699 {
    public int countRestrictedPaths(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int [] toLast = new int[n];
        for (int i = 1; i < n; i++) {
            List<Integer> temp = new ArrayList();
            dfs(i,n,edges,visited,0,temp);
            temp.sort(null);
            System.out.println(temp);
            toLast[i-1]= temp.get(0);
        }
        int answer=0;
        System.out.println(Arrays.toString(toLast));
        return  answer;
    }

    private void dfs(int i, int n, int[][] edges, boolean[] visited,int cost,List<Integer> temp) {
        visited[i-1] =true;
        if (i==n){
            temp.add(cost);
            return;
        }
        for (int j = 0; j < edges.length; j++) {
            if (edges[j][0]==i&&!visited[edges[j][1]]){
                dfs(edges[j][1],n,edges,visited,edges[j][2]+cost,temp);
            }
        }
        visited[i-1] = false;
    }
}
