package contest.The276;

/**
 * @author chenz at 10:18 on 2022/1/16 .
 */
public class S3 {
    public long mostPoints(int[][] questions) {
        return maxPoint(questions,0,0);
    }

    private long maxPoint(int[][]q,int i,long res){
        if (i> q.length){
            return res;
        }
        return Math.max(maxPoint(q,i+q[i][1]+1,res+q[i][0]),maxPoint(q,i+1,res));
    }
}
