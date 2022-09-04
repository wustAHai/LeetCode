package contest.The287;

import top500.T208实现Trie前缀树;

import java.util.*;

/**
 * @author chenz at 10:29 on 2022/4/3 .
 */
public class Solution {
    public int convertTime(String current, String correct) {
        int ans = 0;
        int left = time(correct) - time(current);
        int[] a = {60, 15, 5, 1};
        for (int i = 0; i < a.length; i++) {
            if (left >= a[i]) {
                int t = left / a[i];
                ans += t;
                left -= t * a[i];
            }
        }
        return ans;
    }

    int time(String a) {
        String[] split = a.split(":");
        return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> win = new ArrayList<>();
        List<Integer> lose1 = new ArrayList<>();
        TreeMap<Integer,int[]> treeMap = new TreeMap<>();
        for (int[] match : matches) {
            int[] w = treeMap.getOrDefault(match[0], new int[2]);
            int[] l = treeMap.getOrDefault(match[1], new int[2]);
            w[0]++;
            l[0]++;
            w[1]++;
            treeMap.put(match[0],w);
            treeMap.put(match[1],l);
        }
        for (Map.Entry<Integer, int[]> integerEntry : treeMap.entrySet()) {
            Integer key = integerEntry.getKey();
            int[] value = integerEntry.getValue();
            if (value[0]==value[1]){
                win.add(key);
            }else if (value[0]==value[1]+1){
                lose1.add(key);
            }
        }
        ans.add(win);
        ans.add(lose1);
        return ans;
    }

    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        long count =0;
        int lo =1;
        int hi =candies[candies.length-1];
        int ans = 0;
        while (lo<=hi){
            int mid =  (hi-lo)/2+lo;
            count=0;
            for (int i = biSearch(candies,mid); i < candies.length; i++) {
                count+=candies[i]/mid;
            }
            if (count>=k){
                ans=Math.max(ans,mid);
                lo=mid+1;
            }else {
                hi=mid-1;
            }
        }
        return ans;
    }
    int biSearch(int[] candies,int target){
        int lo=0;
        int hi=candies.length-1;
        while (lo<hi){
            int mid = (hi-lo)/2+lo;
            if (candies[mid]<target){
                lo = mid+1;
            }else {
                hi =mid;
            }
        }
        return lo;
    }

    class Encrypter {

        private Map<Character,String> kvMap = new HashMap<>();
        private Map<String,Set<Character>> vkMap = new HashMap<>();
        private Map<String,Integer> count = new HashMap<>();

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (int i = 0; i < keys.length; i++) {
                kvMap.put(keys[i],values[i]);
                Set<Character> orDefault = vkMap.getOrDefault(values[i], new HashSet<>());
                orDefault.add(keys[i]);
                vkMap.put(values[i],orDefault);
            }
            for (String s : dictionary) {
                String encrypt = encrypt(s);
                if (encrypt!=null){
                    count.put(encrypt,count.getOrDefault(encrypt,0)+1);
                }
            }
        }

        public String encrypt(String word1) {
            StringBuilder sb  = new StringBuilder();
            for (int i = 0; i < word1.length(); i++) {
                String s = kvMap.get(word1.charAt(i));
                if (s == null){
                    return null;
                }
                sb.append(s);
            }
            return sb.toString();
        }

        public int decrypt(String word2) {
            return count.getOrDefault(word2,0);
        }
    }

}

