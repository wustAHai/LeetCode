package mid;

/**
 * Created by chenz at 9:09 on 2021/3/3
 */
public class L338 {
    public int[] countBits(int num) {
        int [] ans = new int[num+1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}
