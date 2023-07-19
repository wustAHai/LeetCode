package hard;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.HashSet;

/**
 * @author chenz at 15:49 on 2022/9/18 .
 */
public class L827 {
    int[] p;
    int[] size;
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        p = new int[n*n];
        size = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            p[i]=i;
            size[i]=1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==1){
                    for (int[] ints : dir) {
                        int r = ints[0]+i;
                        int c = ints[1]+j;
                        if (r>=0&&r<n&&c>=0&&c<n&&grid[r][c]==1){
                            union(i*n+j,r*n+c);
                        }
                    }
                }
            }
        }
        if (size[0]==n*n){
            return n*n;
        }
        int max = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==0){
                    set.clear();
                    for (int[] ints : dir) {
                        int r = ints[0]+i;
                        int c = ints[1]+j;
                        if (r>=0&&r<n&&c>=0&&c<n&&grid[r][c]==1){
                            set.add(findParent(r*i+j));
                        }
                    }
                    int sum = 1;
                    for (Integer integer : set) {
                        sum+=size[integer];
                    }
                    System.out.println(set);
                    max= Math.max(max,sum);
                }
            }
        }
        return max;
    }
//[[0,0,0,0,0,0,0]
// [0,1,1,1,1,0,0],
// [0,1,0,0,1,0,0],
// [1,0,1,0,1,0,0],
// [0,1,0,0,1,0,0],
// [0,1,0,0,1,0,0],
// [0,1,1,1,1,0,0]]

    public static void main(String[] args) {
        L827 m = new L827();
        int[][] grid = new int[][]{{0,0,0,0,0,0,0},
                                   {0,1,1,1,1,0,0},
                                   {0,1,0,0,1,0,0},
                                   {1,0,1,0,1,0,0},
                                   {0,1,0,0,1,0,0},
                                   {0,1,0,0,1,0,0},
                                   {0,1,1,1,1,0,0}};
        System.out.println(m.largestIsland(grid));
    }

    void union(int i,int j){
        //i<j
        if (i>j){
            union(j,i);
        }
        int pi = findParent(i);
        int pj = findParent(j);
        if (pi==pj){
            return;
        }
        if (pi<pj){
            p[pj]=pi;
            size[pi]+=size[pj];
        }else {
            p[pi]=pj;
            size[pj]+=size[pi];
        }
    }
    int findParent(int i){
        if (p[i]!=i){
            p[i] = findParent(p[i]);
        }
        return p[i];
    }


}
