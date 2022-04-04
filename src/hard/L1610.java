package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenz at 22:07 on 2021/12/16 .
 */
public class L1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int maxCnt = 0;
        int selfCnt = 0;
        int mx = location.get(0);
        int my = location.get(1);
        List<Double> degrees = new ArrayList<>();
        for (List<Integer> point : points) {
            int x =  point.get(0);
            int y =  point.get(1);
            if (mx==x&&my==y){
                selfCnt++;
            }else {
                degrees.add(Math.atan2(y-my,x-mx));
            }
        }
        Collections.sort(degrees);
        int size = degrees.size();
        for (int i = 0; i < size; i++) {
            degrees.add(degrees.get(i)+2*Math.PI);
        }
        double ag = angle*Math.PI/180;
        int right = 0;
        for (int i = 0; i < size; i++) {
            Double cur = degrees.get(i) + ag;
            while (right<degrees.size()&&degrees.get(right)<=cur){
                right++;
            }
            maxCnt = Math.max(maxCnt,right- i);
        }
        return maxCnt + selfCnt;
    }

}
