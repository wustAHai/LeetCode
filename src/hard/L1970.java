package hard;

import java.util.Arrays;

public class L1970 {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        boolean[] valid = new boolean[n];
        UnionFind unionFind = new UnionFind(n + 2);
        for (int i = n-1; i >=0; i--) {
            int r= cells[i][0] -1;
            int c= cells[i][1] -1;
            int id = r*col+c;
            valid[id] = true;
            if (r>0){
                int r1 = r-1;
                if (valid[r1*col+c]){
                    unionFind.unite(r1*col+c,id);
                }
            }
            if (r<row-1){
                int r1 = r+1;
                if (valid[r1*col+c]){
                    unionFind.unite(r1*col+c,id);
                }
            }
            if(c>0){
                int c1 = c-1;
                if (valid[r*col+c1]){
                    unionFind.unite(r*col+c1,id);
                }
            }
            if (c<col-1){
                int c1 = c+1;
                if (valid[r*col+c1]){
                    unionFind.unite(r*col+c1,id);
                }
            }
            if (r==0){
                unionFind.unite(id,n);
            }
            if (r==row-1){
                unionFind.unite(id,n+1);
            }
            if (unionFind.connected(n,n+1)){
                return i;
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
