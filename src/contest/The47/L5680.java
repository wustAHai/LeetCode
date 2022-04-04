package contest.The47;

/**
 * Created by chenz at 22:31 on 2021/3/6
 */
public class L5680 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (x==points[i][0]||y==points[i][1]){
                min=Math.min(min,Math.abs(x-points[i][0])+Math.abs(y-points[i][1]));
            }
        }
        if (min==Integer.MAX_VALUE){
            return -1;
        }
        for (int i = 0; i < points.length; i++) {
            if (x==points[i][0]||y==points[i][1]){
                if (min==Math.abs(x-points[i][0])+Math.abs(y-points[i][1])){
                    return i;
                }
            }
        }
        return  0;
    }
}
