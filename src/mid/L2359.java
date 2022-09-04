package mid;

import contest.The289.Solution;

import java.util.TreeSet;

/**
 * @author chenz at 21:06 on 2022/8/1 .
 */
public class L2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[][] visit = new int[edges.length][2];
        int i = node1;
        int l = 0;
        while (i>=0&&visit[i][0]==0){
            visit[i][0]++;
            visit[i][1]= l;
            l++;
            i = edges[i];
        }
        i=node2;
        l=0;
        int ans = -1;
        int[][] visit1 = new int[edges.length][2];
        while (i>=0&&visit1[i][0]==0){
            visit1[i][0]++;
            visit1[i][1]= l;
            l++;
            i = edges[i];
        }
        int minus = Integer.MAX_VALUE;
        for (int j = 0; j < edges.length; j++) {
            if (visit[j][0]==1&&visit1[j][0]==1&&minus>Math.max(visit[j][1],visit1[j][1])){
                minus = Math.max(visit[j][1],visit1[j][1]);
                ans = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,0,2,4,5};
        new L2359().closestMeetingNode(arr,3,2);
    }
}
