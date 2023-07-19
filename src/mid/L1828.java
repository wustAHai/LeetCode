package mid;

/**
 * @author chenz at 19:11 on 2023/1/24 .
 */
public class L1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points) {
                int x = point[0] - queries[i][0];
                int y = point[1] - queries[i][1];
                if (x*x+y*y<= queries[i][2]*queries[i][2]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
