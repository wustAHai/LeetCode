package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenz at 21:16 on 2021/2/9
 */
public class L992 {
    public int subarraysWithKDistinct(int[] A, int K) {//暴力解法超时
        int p = 0;
        int q = p + K - 1;
        int ans = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < K - 1; i++) {
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
        }
        while (p <= A.length - K) {
            while (q < A.length) {
                hashMap.put(A[q], hashMap.getOrDefault(A[q], 0) + 1);
                if (hashMap.size() == K) {
                    ans++;
                    q++;
                } else if (hashMap.size() < K) {
                    q++;
                } else {
                    hashMap.clear();
                    break;
                }
                p++;
                q++;
                hashMap.clear();
            }
        }
        return ans;
    }
}
