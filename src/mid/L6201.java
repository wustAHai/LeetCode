package mid;

/**
 * @author chenz at 21:10 on 2022/10/9 .
 */
public class L6201 {
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        int pre = ans[0];
        for (int i = 1; i < pref.length; i++) {
            ans[i]=pre^pref[i];
            pre^=ans[i];
        }
        return ans;
    }
}
