package mid;

/**
 * @author chenz at 22:14 on 2022/10/13 .
 */
public class L769 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            if (max==i){
                ans++;
            }
        }
        return ans;
    }
}
