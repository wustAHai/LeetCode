package top500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 18:54 on 2022/4/6 .
 */
public class T310最小高度树 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] =1;
            matrix[edge[1]][edge[0]] =1;
        }
        for (int i = 0; i < n; i++) {
            for (int j= i+1; j < n; j++) {

            }
        }
        return new ArrayList<>();
    }
}
