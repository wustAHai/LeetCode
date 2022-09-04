package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenz at 18:59 on 2022/7/20 .
 */
public class L1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m  = grid.length;
        int n  = grid[0].length;
        int l =  m*n;
        k %= m*n;
        for (int i = 0; i < k; i++) {
            int j  = i;
            int old;
            int next;
            int nextVal;
            old =  grid[j/n][j%n];
            while (old>0){
                next =  (j+k)%l;
                grid[next/n] [next%n] = -old;
                nextVal = grid[next/n][next%n];
                old = nextVal;
                j+=k;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] ints : grid) {
            ArrayList<Integer> integers = new ArrayList<>(ints.length);
            for (int anInt : ints) {
                integers.add(-anInt);
            }
            ans.add(integers);
        }
        return ans;
    }

}
