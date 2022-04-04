package mid;

/**
 * Created by chenz at 9:08 on 2021/2/8
 */
public class L978 {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 0;
        int p = 0;
        int q = 0;
        while (q < arr.length) {
            int len = q - p;
            if (len == 0) {
                ans = Math.max(len + 1, ans);
            } else if (len == 1) {
                if (arr[q] == arr[p]) {
                    p++;
                } else {
                    ans = Math.max(len + 1, ans);
                }
            } else if (len >= 2) {
                int x1 = arr[q] - arr[q - 1];
                int x2 = arr[q - 1] - arr[q - 2];
                if (x1 < 0 && x2 > 0 || x2 < 0 && x1 > 0) {
                    ans = Math.max(len + 1, ans);
                } else {
                    p = q - 1;
                }
            }
            q++;
        }
        return ans;
    }
}
