package contest2023;

import easy.ListNode;
import easy.TreeNode;

import java.util.*;

/**
 * @author chenz at 12:13 on 2023/1/1 .
 */
public class The326 {
    int max = 0;

    public int countDigits(int num) {
        int i = num;
        int ans = 0;
        while (i > 0) {
            if (num % (i % 10) == 0) {
                ans++;
            }
            i /= 10;
        }
        return ans;
    }

    public int distinctPrimeFactors(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        boolean[] arr = new boolean[1001];
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                arr[nums[i]] = true;
            } else {
                for (Integer integer : list) {
                    if (integer * 2 <= nums[i]) {
                        if (nums[i] % integer == 0) {
                            arr[integer] = true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        int ans = 0;
        for (boolean b : arr) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }

    boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                arr[manager[i]].add(i);
            }
        }
        dfs(headID, 0, informTime, arr);
        return max;
    }

    private void dfs(int headID, int i, int[] informTime, List<Integer>[] arr) {
        List<Integer> list = arr[headID];
        if (list.isEmpty()) {
            return;
        }
        i += informTime[headID];
        for (Integer integer : list) {
            max = Math.max(max, i);
            dfs(integer, i, informTime, arr);
        }
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int t = 1;
        while (t < bound) {
            a.add(t);
            if (x == 1) {
                break;
            }
            t *= x;
        }
        t = 1;
        while (t < bound) {
            b.add(t);
            if (y == 1) {
                break;
            }
            t *= y;
        }
        for (int i = 0; i < a.size(); i++) {
            Integer integer = a.get(i);
            for (int j = 0; j < b.size(); j++) {
                int c = integer + b.get(j);
                if (c <= bound) {
                    set.add(c);
                } else {
                    break;
                }
            }
        }
        return new ArrayList<>(set);

    }

    public boolean isValid(String s) {
        //abcabc aabcbc ababcc aaabcbcbc
        if (s.length() % 3 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                stack.push(ch);
            } else if (ch == 'b') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.push(ch);
            } else {
                if (stack.size() < 2) {
                    return false;
                }
                Character pop = stack.pop();
                Character pop1 = stack.pop();
                if (!(pop == 'b' && pop1 == 'a')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        //crcoakroak
        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        int[] d = new int[5];
        Map<Character, Integer> map = new HashMap<>(5);
        for (int i = 0; i < "croak".length(); i++) {
            map.put("croak".charAt(i), i);
        }
        int sum = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int idx = map.get(ch);
            if (idx > 0) {
                if (--d[idx - 1] < 0) {
                    return -1;
                }
            }
            d[idx]++;
            int tempSum = 0;
            for (int j = 0; j < 4; j++) {
                tempSum += d[j];
            }
            sum = Math.max(tempSum, sum);
        }
        for (int i = 0; i < 4; i++) {
            if (d[i] > 0) {
                return -1;
            }
        }

        return sum;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean ok = isOk(root, 0, limit);
        return ok ? root : null;
    }

    private boolean isOk(TreeNode root, int sum, int limit) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum + root.val >= limit;
        }
        boolean left = isOk(root.left, sum + root.val, limit);
        boolean right = isOk(root.right, sum + root.val, limit);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return left || right;
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Integer[] arr = new Integer[values.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return values[o2] - values[o1];
            }
        });
        int cnt = 0;
        Map<Integer, Integer> labelCnt = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < arr.length && cnt < numWanted; i++) {
            int c = labelCnt.getOrDefault(labels[arr[i]], 0);
            if (c < useLimit) {
                cnt++;
                ret += values[arr[i]];
                labelCnt.put(labels[arr[i]], c + 1);
            }
        }
        return ret;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int n = grid.length;
        if (grid[n - 1][n - 1] == 1 || grid[0][0] == 1) {
            return -1;
        }
        boolean[][] visit = new boolean[n][n];
        Deque<Integer> deque = new LinkedList<>();
        visit[0][0] = true;
        int val = 1;
        deque.add(0);
        while (!deque.isEmpty()) {
            int size = deque.size();
            val++;
            for (int i = 0; i < size; i++) {
                Integer pop = deque.pop();
                int r = pop / n;
                int c = pop % n;
                for (int[] ints : dir) {
                    int nr = ints[0] + r;
                    int nc = ints[1] + c;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && grid[nr][nc] == 0) {
                        if (nr == n - 1 && nc == n - 1) {
                            return val;
                        }
                        deque.add(nr * n + nc);
                    }
                }
            }
        }
        if (visit[n - 1][n - 1]) {
            return val;
        }
        return -1;
    }

    public double[] sampleStats(int[] count) {
        double min = 0;
        double max = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                min = i;
                break;
            }
        }
        for (int i = 255; i >= 0; i--) {
            if (count[i] != 0) {
                max = i;
                break;
            }
        }
        double sum = 0;
        int cnt = 0;
        int maxCnt = 0;
        double mode = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * count[i];
            cnt += count[i];
            if (count[i] > maxCnt) {
                maxCnt = count[i];
                mode = i;
            }
        }
        double median = 0;
        if (cnt % 2 == 0) {
            median = (getK(cnt / 2, count) + getK(cnt / 2 - 1, count)) / 2.0;
        } else {
            median = getK(cnt / 2, count);
        }

        return new double[]{min, max, sum / cnt, median, mode};
    }

    int getK(int k, int[] cnt) {
        int c = 0;
        for (int i = 0; i < 256; i++) {
            c += cnt[i];
            if (c >= k) {
                return i;
            }
        }
        return -1;
    }

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int a = prices[0] + prices[1];
        if (a > money) {
            return money;
        } else {
            return money - a;
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
        int dp[] = new int[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String s1 : dictionary) {
            set.add(s1);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            String subS = s.substring(0, i);
            for (String s1 : dictionary) {
                if (subS.endsWith(s1)) {
                    dp[i] = Math.min(dp[i], dp[i - s1.length()]);
                }
            }
        }
        return dp[dp.length - 1];
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> ret = new ArrayList<>();

        dfs(null, root, ret, set);
        return ret;
    }

    private void dfs(TreeNode p, TreeNode node, List<TreeNode> ret, Set<Integer> set) {
        if (node == null) {
            return;
        }
        if (set.contains(node.val)) {
            if (p != null) {
                if (p.left == node) {
                    p.left = null;
                }
                if (p.right == node) {
                    p.right = null;
                }
            }
            dfs(null, node.left, ret, set);
            dfs(null, node.right, ret, set);
        } else {
            if (p == null) {
                ret.add(node);
            }
            dfs(node, node.left, ret, set);
            dfs(node, node.right, ret, set);
        }
    }

    public int maxRepOpt1(String text) {
        char[] chars = text.toCharArray();
        int[] cnt = new int[26];
        for (char aChar : chars) {
            cnt[aChar - 'a']++;
        }
        int ret = 0;
        for (int i = 0; i < chars.length; ) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            int len = j - i;
            if (len < cnt[chars[i] - 'a'] && (j < chars.length || i > 0)) {
                ret = Math.max(ret, len + 1);
            }
            j++;
            if (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            ret = Math.max(ret, Math.min(j - i, cnt[chars[i] - 'a']));
            i += len;
        }
        return ret;
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        Integer[] arr = new Integer[reward1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (reward2[o2] - reward1[o2]) - (reward2[o2] - reward1[o1]);
            }
        });
        int sum = 0;
        for (int i = 0; i < arr.length - k; i++) {
            sum += reward2[arr[i]] - reward1[arr[i]];
        }
        for (int i : reward1) {
            sum += i;
        }
        return sum;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] nums = new int[12];
        for (String word : words) {
            nums[f(word)]++;
        }
        for (int i = 9; i >= 0; i--) {
            nums[i] += nums[i + 1];
        }
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ret[i] = nums[f(queries[i]) + 1];
        }
        return ret;
    }

    int f(String s) {
        int c = 1;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c1 == ch) {
                c++;
            } else if (c1 < ch) {
                c = 1;
                ch = c1;
            }
        }
        return c;
    }

    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 1) {
            return n;
        }
        return n / 2;

    }

    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = dfs(i, j, land, visited);
                if (k > 0) {
                    list.add(k);
                }
            }
        }
        list.sort(null);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] land, boolean[][] visited) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
            return 0;
        }
        if (land[i][j] != 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;

        return 1 + dfs(i + 1, j, land, visited) + dfs(i - 1, j, land, visited) + dfs(i, j - 1, land, visited) +
                dfs(i, j + 1, land, visited) + dfs(i - 1, j + 1, land, visited) + dfs(i - 1, j - 1, land, visited) + dfs(i + 1, j - 1, land, visited) + dfs(i + 1, j + 1, land, visited);
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[] uarr = new int[colsum.length];
        int[] larr = new int[colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper >= lower) {
                    upper--;
                    uarr[i] = 1;
                } else {
                    lower--;
                    larr[i] = 1;
                }
            } else if (colsum[i] == 2) {
                upper--;
                lower--;
                uarr[i] = 1;
                larr[i] = 1;
            }
            if (upper < 0 || lower < 0) {
                return new ArrayList<>();
            }
        }
        if (upper == 0 && lower == 0) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            for (int i : uarr) {
                list1.add(i);
            }
            List<Integer> list2 = new ArrayList<>();
            for (int i : larr) {
                list2.add(i);
            }
            list.add(list1);
            list.add(list2);
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    class FrequencyTracker {
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> freCnt = new HashMap<>();

        public FrequencyTracker() {

        }

        public void add(int number) {
            int fre = numCnt.getOrDefault(number, 0);
            int cnt = freCnt.getOrDefault(fre, 0);
            if (cnt == 1) {
                freCnt.remove(fre);
            } else if (cnt > 1) {
                freCnt.put(fre, cnt - 1);
            }
            numCnt.put(number, fre + 1);
            freCnt.put(fre + 1, freCnt.getOrDefault(fre + 1, 0) + 1);
        }

        public void deleteOne(int number) {
            int fre = numCnt.getOrDefault(number, 0);
            if (fre == 0) {
                return;
            } else if (fre == 1) {
                numCnt.remove(number);
            } else {
                numCnt.put(number, fre - 1);
                freCnt.put(fre - 1, freCnt.getOrDefault(fre - 1, 0) + 1);
            }
            int cnt = freCnt.getOrDefault(fre, 0);
            if (cnt == 1) {
                freCnt.remove(fre);
            } else if (cnt > 1) {
                freCnt.put(fre, cnt - 1);
            }

        }

        public boolean hasFrequency(int frequency) {
            return freCnt.getOrDefault(frequency, 0) > 0;
        }
    }


    public boolean isCircularSentence(String sentence) {
        String[] strings = sentence.split(" ");
        String f = strings[0];
        String l = strings[strings.length-1];
        if (f.charAt(0) != l.charAt(l.length()-1)){
            return false;
        }
        for (int i = 1; i < strings.length; i++) {
            String pre = strings[i-1];
            String now = strings[i];
            if (pre.charAt(pre.length()-1)!=now.charAt(0)){
                return false;
            }
        }
        return true;
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;
        int l = 0;
        int r = 0;
        while (r<nums.length){
            if (nums[r]>threshold){
                max = Math.max(max,r-l);
                l=r+1;
                r++;
            }else {
                if (r==l){
                    if (nums[r]%2==0){
                        r++;
                        max = Math.max(max,r-l);
                    }else {
                        r++;
                        l++;
                    }
                }else {
                    if(nums[r]%2==nums[r-1]%2){
                        l=r;
                    }else {
                        r++;
                        max = Math.max(max,r-l);
                    }
                }
            }
        }
        return  max;
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 2; i <= n/2&&i<=(n-i) ; i++) {
            if (isPrime1(i)&&isPrime1(n-i)){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                list1.add(n-i);
                list.add(list1);
            }
        }
        return list;
    }

    boolean isPrime1(int num){
        if (num<2){
            return false;
        }
        if (num == 2 || num == 3){
            return true;
        }
        for (int i = 2; i*i <= num ; i++) {
            if (num%i==0){
                return false;
            }
        }
        return true;
    }


    public long continuousSubarrays(int[] nums) {
        //int[] cnt = new int[1000000001];
        Map<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        long ans = 0;
        while (r<nums.length){
            while (r<nums.length){
                if (isValid(nums[l],nums[r],map)){
                    map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                    r++;
                }else {
                    break;
                }
            }
            long len = r-l;
            if (r == nums.length){
                ans+= len*(len+1)/2;
            }else {
                ans+=len;
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                l++;
            }
        }
        return ans;
    }
    boolean isValid(int s,int num,Map<Integer,Integer> map){
        int min = Math.max(1,s-2);
        for (int i= min;i<=s+2;i++){
            if (map.getOrDefault(i,0)>0&&Math.abs(num-i)>2){
                return false;
            }
        }
        return true;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        while (l1!=null){
            st1.push(l1);
            l1=l1.next;
        }
        while (l2!=null){
            st2.push(l2);
            l2=l2.next;
        }
        int num = 0;
        ListNode next = null;
        ListNode dummyHead = new ListNode();
        while (!st1.isEmpty()&&!st2.isEmpty()){
            ListNode pop = st1.pop();
            ListNode pop1 = st2.pop();
            num+=pop.val+pop1.val;
            ListNode listNode = new ListNode(num%10);
            num/=10;
            listNode.next = next;
            next = listNode;
            dummyHead.next = listNode;
        }
        if (st1.isEmpty()){
            st1 = st2;
        }
        if (st1.isEmpty()){
            if (num!=0){
                ListNode listNode = new ListNode(num);
                listNode.next = dummyHead.next;
                return listNode;
            }else {
                return dummyHead.next;
            }
        }
        while (!st1.isEmpty()){
            ListNode pop = st1.pop();
            num+=pop.val;
            ListNode listNode = new ListNode(num%10);
            num/=10;
            listNode.next = next;
            next = listNode;
            dummyHead.next = listNode;
        }
        if (num!=0){
            ListNode listNode = new ListNode(num);
            listNode.next = dummyHead.next;
            return listNode;
        }else {
            return dummyHead.next;
        }
    }



    public static void main(String[] args) {
        new The326().continuousSubarrays(new int[]{5,4,2,4});
    }
}
