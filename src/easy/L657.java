package easy;

/**
 * Created by chenz at 16:39 on 2021/1/31
 */
public class L657 {
    public boolean judgeCircle(String moves) {
        int r, l, u, d;
        r = l = u = d = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') {
                r++;
            } else if (moves.charAt(i) == 'L') {
                l++;
            } else if (moves.charAt(i) == 'U') {
                u++;
            } else {
                d++;
            }
        }
        if (r == l && u == d) {
            return true;
        }
        return false;
    }
}
