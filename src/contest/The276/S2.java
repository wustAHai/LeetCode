package contest.The276;

/**
 * @author chenz at 10:18 on 2022/1/16 .
 */
public class S2 {
    public int minMoves(int target, int maxDoubles) {
        int n = 0;
        while (target!=1){
            if (target%2==1){
                target--;
                n++;
            }else {
                if (maxDoubles>0){
                    target/=2;
                    maxDoubles--;
                    n++;
                }else {
                    n+=target-1;
                    target = 1;
                }
            }
        }
        return n;
    }
}
