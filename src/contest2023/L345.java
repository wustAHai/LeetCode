package contest2023;

import java.util.*;

/**
 * @author chenz at 10:29 on 2023/5/14 .
 */
public class L345 {
    public int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        int idx = 0;
        int t = 1;
        arr[0]=1;
        while (arr[(idx+k*t)%n]==0){
            arr[(idx+k*t)%n]=1;
            idx = (idx+k*t)%n;
            t++;
        }
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                list.add(i+1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public boolean doesValidArrayExist(int[] derived) {
        if (derived.length==1){
            return  derived[0]==0;
        }
        if (derived.length==2){
            return  derived[0] == derived[1];
        }
        int xor = derived[0];
        for (int i = 1; i < derived.length-1; i++) {
            xor ^= derived[i];
        }
        return derived[derived.length-1] == xor;
    }

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int j = 1;j<n;j++){
            for (int i = 0; i < m; i++) {
                if (i-1>=0&&grid[i][j]>grid[i-1][j-1]&&dp[i-1][j-1]==j-1){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
                if (grid[i][j]>grid[i][j-1]&&dp[i][j-1]==j-1){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-1]+1);
                }
                if (i+1<m&&grid[i][j]>grid[i+1][j-1]&&dp[i][j-1]==j-1){
                    dp[i][j] = Math.max(dp[i][j],dp[i+1][j-1]+1);
                }
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }


    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] arr = new  ArrayList[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        int cnt = 0;
        for (int[] edge : edges) {
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            if (visit[i]){
                continue;
            }
            visit[i] = true;
            if(arr[i].isEmpty()) {
                cnt++;
            }else {
                int length = arr[i].size();
                boolean flag = true;

                for (Integer integer : arr[i]) {
                    if (visit[integer]){
                        flag=false;
                    }
                    visit[integer]= true;
                    if (arr[i].size()!=length){
                        flag = false;
                    }
                }
                if (flag){
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    for (Integer integer : arr[i]) {
                        set.add(integer);
                    }
                    for (Integer integer : arr[i]) {
                        for (Integer integer1 : arr[integer]) {
                            if (!set.contains(integer1)){
                                flag=false;
                                break;
                            }
                            visit[integer1] = true;
                        }
                        if (!flag){
                            break;
                        }
                    }
                    if (flag){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }


    public int[] addNegabinary(int[] arr1, int[] arr2) {
        // 101 1-10  -10-10
        // 101 1 00  11110
        int[] ret = new int[Math.max(arr1.length,arr2.length)+1];
        int l1 =arr1.length-1;
        int l2 =arr2.length-1;
        int l = ret.length-1;
        int jin = 0;
        int temp =0;
        while (l1>=0&&l2>=0){
            temp = arr1[l1]+arr2[l2]+jin;
            if (temp==0||temp==1){
                ret[l] = temp;
                jin = 0;
            }else if (temp== -1){
                jin = 1;
                ret[l] = 1;
            }else if (temp>=2){
                ret[l]= temp%2;
                jin = -1;
            }
            l1--;
            l2--;
            l--;
        }
        int[] arr=arr1;
        if (l1>=0){
            arr=arr1;
        }else {
            arr = arr2;
        }
        l1 = Math.max(l1,l2);
        while (l1>=0){
            temp = jin+arr[l1];
            if (temp==0||temp==1){
                ret[l] = temp;
                jin = 0;
            }else if (temp== -1){
                jin = 1;
                ret[l] = 1;
            }else if (temp>=2){
                ret[l]= temp%2;
                jin = -1;
            }
            l1--;
            l--;
        }
        if (jin == 1){
            ret[l] = 1;
        }
        if (jin == -1){
            ret[l]= 1;
            ret[l-1] = 1;
        }
        int i = 0;
        while (i<ret.length&&ret[i]==0){
            i++;
        }
        if (i==ret.length){
            return new int[]{0};
        }
        int[] ans = new int[ret.length-i];
        System.arraycopy(ret,i,ans,0,ans.length);
        return ans;
    }

    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        int length = tiles.length();
        int type = 0;
        for (int i = 0; i < length; i++) {
            char ch = tiles.charAt(i);
            if (cnt[ch-'A']==0){
                type++;
            }
            cnt[ch-'A']++;
        }
        int ret = type;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i]>1){
                list.add(cnt[i]);
            }
        }
        //aabb ab ba aa bb
        for (int i = 2; i <= length; i++) {
            int temp= aFunc(i, length);
            for (Integer integer : list) {
                temp/=aFunc(i,integer);
            }
        }

        return ret;
    }
    int aFunc(int i,int n){
        int ret = 1;
        while (i>0){
            ret*=n;
            n--;
            i--;
        }
        return ret;
    }

    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0]+o2[1]-1)/o2[1] - (o1[0]+o1[1]-1)/o1[1];
            }
        });
        int min = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (vat[i]==0){
                continue;
            }
            if (bucket[i]==0){
                bucket[i]++;
                min++;
            }
            priorityQueue.add(new int[]{vat[i],bucket[i]});
        }
        int i = min;
        if (!priorityQueue.isEmpty()){
            min+=fun(priorityQueue.peek());
        }
        if (!priorityQueue.isEmpty()){
            while (i<min){
                i++;
                int[] poll = priorityQueue.poll();
                poll[1]++;
                priorityQueue.add(poll);
                min = Math.min(i+fun(priorityQueue.peek()),min);
            }
        }
        return min;
    }
    int fun(int[]o2){
        return (o2[0]+o2[1]-1)/o2[1];
    }


    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()){
                stack.push(ch);
            }else {
                if (stack.peek()=='A'&&ch=='B'||stack.peek()=='C'||ch=='D'){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }

    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int l = 0;
        int r = 0;
        if (length%2==1){
            l = length/2-1;
            r = length/2+1;
        }else {
            r = length/2;
            l = length-1-r;
        }
        while (l>=0){
            if (chars[l]<chars[r]){
                chars[r] = chars[l];
            }else if (chars[l] > chars[r]){
                chars[l] = chars[r];
            }
            l--;
            r++;
        }
        return  new String(chars);
    }

    static boolean fun(int i){
        return dfs(i,i*i+"",0);
    }

    static boolean dfs(int target,String s,int index){
        if (target<0){
            return false;
        }
        if (index==s.length()&&target!=0){
            return false;
        }
        if (index == s.length()){
            return true;
        }
        boolean b = false;
        for (int i = 1 ; i+index<=s.length();i++){
            b=b||dfs(target-Integer.parseInt(s.substring(index,i+index)),s,index+i);
            if (b){
                return true;
            }
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            if (fun(i)){
                ans+=i*i;
            }
        }
        return ans;
    }


}
