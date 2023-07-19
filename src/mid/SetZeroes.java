package mid;

import java.util.Arrays;

/**
 * @author chenz at 20:10 on 2022/9/30 .
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]==1){
                Arrays.fill(matrix[i],0);
            }
        }
        for(int i=0;i<col.length;i++){
            if (col[i]==1){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
    }
}
