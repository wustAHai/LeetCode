package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 18:55 on 2023/3/15 .
 */
public class L1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        List[] arr = new ArrayList[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  new ArrayList<Integer>();
        }
        for (int[] road : roads) {
            arr[road[0]].add(road[1]);
            arr[road[1]].add(road[0]);
        }
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
               int m =  arr[i].size()+arr[j].size();
               if (arr[i].contains(j)){
                   m--;
               }
               max = Math.max(m,max);
            }
        }
        return max;
    }
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        boolean[] vis = new boolean[n];
        String res = s;
        // 将 s 延长一倍，方便截取轮转后的字符串 t
        s = s + s;
        for (int i = 0; !vis[i]; i = (i + b) % n) {
            vis[i] = true;
            for (int j = 0; j < 10; j++) {
                int kLimit = b % 2 == 0 ? 0 : 9;
                for (int k = 0; k <= kLimit; k++) {
                    // 每次进行累加之前，重新截取 t
                    char[] t = s.substring(n-i,  2*n-i).toCharArray();
                    for (int p = 1; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + j * a) % 10);
                    }
                    for (int p = 0; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + k * a) % 10);
                    }
                    String tStr = new String(t);
                    if (tStr.compareTo(res) < 0) {
                        res = tStr;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "3456";
        //abcdabcd
        a+=a;
        System.out.println(a.substring(4-1,7));
        System.out.println(a.substring(1,5));
    }
}
