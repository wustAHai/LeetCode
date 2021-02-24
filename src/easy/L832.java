package easy;

/**
 * Created by chenz at 19:34 on 2021/2/24
 */
public class L832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int col = A.length/2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < col; j++) {
                int temp = A[i][j];
                A[i][j]=A[i][A.length-1-j];
                A[i][A.length-1-j] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
        return A;
    }
}
