package mid;

import java.util.HashSet;

/**
 * @author chenz at 8:24 on 2023/7/19 .
 */
public class L874 {


    int[][] dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int ans = 0;
        int dir = 0;
        HashSet<String> ob = new HashSet<>();
        for (int[] obstacle : obstacles) {
            ob.add(obstacle[0]+";"+obstacle[1]);
        }
        for (int command : commands) {
            if (command == -1){
                dir = (dir+1)%4;
            }else if (command == -2){
                dir = (dir-1+4)%4;
            }else {
                for (int i = 0; i < command; i++) {
                    int newX = x+dirs[dir][0];
                    int newY = y+dirs[dir][1];
                    if (ob.contains(newX+";"+newY)){
                        break;
                    }else {
                        x = newX;
                        y = newY;
                        ans = Math.max(ans,x*x+y*y);
                    }
                }
            }
        }
        return ans;
    }
}
