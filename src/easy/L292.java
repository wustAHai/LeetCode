package easy;

/**
 * Created by chenz on 2020/12/28 15:54
 */
public class L292 {
    public boolean canWinNim(int n) {
        //win  1 2 3   5 6 7   9 10
        //lose       4       8
        return n % 4 != 0;
    }
}
