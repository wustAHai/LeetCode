package mid;

/**
 * Created by chenz at 12:25 on 2021/2/5
 */
public class L1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int p = 0;
        int q = 0;
        int sum = 0;
        while (q < n) {
            sum += arr[q];
            if (sum > maxCost) {
                sum -= arr[p];
                p++;
            }
            q++;
        }
        return q - p;
    }
}
