package mid;

import java.util.*;

public class L1631 {
    public int minimumEffortPath(int[][] heights) {
        int m =  heights.length;
        int n =  heights[0].length;
        UnionFind unionFind = new UnionFind(m*n);
        //(i,j) -> i*n + j
        List<int[]> edges = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = i*n+j;
                if (i>0){
                    int i1 = i-1;
                    edges.add(new int[]{val-n,val,Math.abs(heights[i][j]-heights[i1][j])});
                }
                if (j>0){
                    int j1 = j-1;
                    edges.add(new int[]{val-1,val,Math.abs(heights[i][j]-heights[i][j1])});
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int val = edge[2];
            unionFind.unite(a,b);
            if (unionFind.connected(0,m*n-1)){
                return val;
            }
        }
        return 0;
    }
    class UnionFind {
        int[] parent;
        int[] size;
        int n;
        // 当前连通分量数目
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x])); // 递归更新到
        }

        public boolean unite(int x, int y) {
            x = findset(x);
            y = findset(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }//size[x] >= size[y]  往一个大的集合合并
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
        }

        public boolean connected(int x, int y) {
            x = findset(x);
            y = findset(y);
            return x == y;
        }
    }
}
