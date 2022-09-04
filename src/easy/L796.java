package easy;

/**
 * @author chenz at 21:13 on 2022/4/7 .
 */
public class L796 {
    public boolean rotateString(String s, String goal) {
        return s.length()==goal.length()&&(s+s).contains(goal);
    }
}
