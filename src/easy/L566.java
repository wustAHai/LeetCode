package easy;

/**
 * Created by chenz at 10:37 on 2021/1/26
 */
public class L566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (r * c != row * col) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = i * col + j;
                res[index / c][index % c] = nums[i][j];
            }
        }
        return res;
    }
}
