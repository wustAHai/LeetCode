package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 19:24 on 2022/2/15 .
 */
public class L1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m  = matrix.length;
        int n  = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int[] arr0 = new int[m];
        int[] arr1 = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][arr0[i]]>matrix[i][j]){
                    arr0[i] = j;
                }
                if (matrix[arr1[j]][j]<matrix[i][j]){
                    arr1[j]=i;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (arr1[arr0[i]]==i){
                ans.add(matrix[i][arr0[i]]);
            }
        }
        return ans;
    }
}
