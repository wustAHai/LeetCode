package easy;

/**
 * @author chenz at 9:36 on 2022/1/1 .
 */
public class L2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length!=m*n){
            return new int[0][0];
        }
       int[][] ans =  new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(original,i*n,ans[i],0,n);
        }
        return ans;
    }
}
