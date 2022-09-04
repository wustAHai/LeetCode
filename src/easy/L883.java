package easy;

/**
 * @author chenz at 20:05 on 2022/4/26 .
 */
public class L883 {
    public int projectionArea(int[][] grid) {
        int a1=0;
        for (int i = 0; i < grid.length; i++) {
            int rowMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]>0){
                    a1++;
                }
                rowMax = Math.max(grid[i][j],rowMax);
            }
            a1+=rowMax;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int colMax =0;
            for (int j = 0; j < grid.length; j++) {
                colMax=Math.max(colMax,grid[j][i]);
            }
            a1+=colMax;
        }
        return a1;
    }
}
