package contest.The305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenz at 10:37 on 2022/10/30 .
 */
public class C317 {
    public static void main(String[] args) {
        System.out.println(new C317().makeIntegerBeautiful(16, 6));
    }

    public int averageValue(int[] nums) {
        int cnt = 0;
        long sum = 0;
        for (int num : nums) {
            if (num % 3 == 0 && num % 2 == 0) {
                sum += num;
                cnt++;
            }
        }
        if (cnt == 0) return 0;

        return (int) (sum / cnt);
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        Map<String, V> map = new HashMap<>();
        long maxTotal = 0L;
        for (int i = 0; i < n; i++) {
            V v = map.get(creators[i]);
            if (v == null) {
                map.put(creators[i], new V(ids[i], views[i], views[i]));
                maxTotal = Math.max(maxTotal, views[i]);
            } else {
                v.sum += views[i];
                maxTotal = Math.max(v.sum, maxTotal);
                if (views[i] > v.views) {
                    v.views = views[i];
                    v.id = ids[i];
                } else if (views[i] == v.views) {
                    if (ids[i].compareTo(v.id) < 0) {
                        v.id = ids[i];
                    }
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, V> stringVEntry : map.entrySet()) {
            String create = stringVEntry.getKey();
            V value = stringVEntry.getValue();
            if (value.sum == maxTotal) {
                List<String> list = new ArrayList<>();
                list.add(create);
                list.add(value.id);
                ans.add(list);
            }
        }
        return ans;
    }

    public long makeIntegerBeautiful(long n, int target) {
        long ans = 0;
        long mod = 10;
        while (!func(n, ans, target)) {
            long m;
            while ((m = (n + ans) % mod) == 0) {
                mod *= 10;
            }
            ans += mod - m;
        }
        return ans;
    }

    private boolean func(long n, long ans, int target) {
        long sum = ans + n;
        int t = 0;
        while (sum > 0) {
            t += sum % 10;
            sum /= 10;
        }
        return t <= target;
    }

    class V {
        public String id;
        public int views;
        public long sum;

        public V(String id, int views, long sum) {
            this.id = id;
            this.views = views;
            this.sum = sum;
        }
    }
}
