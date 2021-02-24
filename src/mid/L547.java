package mid;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenz at 9:20 on 2021/1/7
 */
public class L547 {
    /*    public int findCircleNum(int[][] isConnected) {
         //深度优先
            int n = isConnected.length;
            boolean []  visited = new boolean[n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i]){
                    continue;
                }
                res++;
                dfs(visited,i,isConnected,n);
            }
            return res;
        }

        private void dfs(boolean[] visited, int i, int[][] isConnected,int n) {
            visited[i]=true;
            for (int j = 0; j < n; j++) {
                if(isConnected[i][j]==1&&!visited[j]){
                    dfs(visited,j,isConnected,n);
                }
            }
        }*/
/*    public int findCircleNum(int[][] isConnected) {
        //广度优先
        int n = isConnected.length;
        boolean [] visited = new  boolean[n];
        Deque<Integer> deque = new LinkedList<>();
        int res=0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                res++;
                visited[i]=true;
                deque.offer(i);
            }
            while (deque.size()>0){
                int  head = deque.remove();
                for (int j = 0; j < n; j++) {
                    if(!visited[j]&&isConnected[head][j]==1){
                        visited[j]=true;
                        deque.offer(j);
                    }
                }
            }
        }
        return res;
    }*/
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        System.out.println(Arrays.toString(parent));
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                    System.out.println(Arrays.toString(parent));
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    @Test
    public void test() {
        int[][] arr = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        System.out.println(findCircleNum(arr));
    }

}
