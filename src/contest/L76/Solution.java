package contest.L76;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenz at 22:29 on 2022/4/16 .
 */
public class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min,Math.abs(num));
        }
        if (min == 0){
            return 0;
        }
        for (int num : nums) {
            if (min==num){
                return num;
            }
        }
        return -min;
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        while (total>=0){
            ans+=total/cost2+1;
            total-=cost1;
        }
        return ans;
    }
   // $20 ，$50，$100，$200 和 $500
    class ATM {

        long[] money; ;
        int[] qian = new int[]{20,50,100,200,500};


        public ATM() {
            money =  new long[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < money.length; i++) {
                money[i]+=banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] ans = new int[5];
            for (int i = 4; i >= 0; i-- ) {
                ans[i] = (int) Math.min(money[i],amount/qian[i]);
                amount-=ans[i]*qian[i];
            }
            if (amount==0){
                for (int i = 0; i < money.length; i++) {
                    money[i]-=ans[i];
                }
                return ans;
            }else {
                return new int[]{-1};
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(64274*500);
        System.out.println(Integer.MAX_VALUE);
    }

    public int maximumScore(int[] scores, int[][] edges) {
        ArrayList[] edg = new ArrayList[scores.length];
        for (int i = 0; i < scores.length; i++) {
            edg[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            edg[edge[0]].add(edge[1]);
            edg[edge[1]].add(edge[0]);
        }
        for (ArrayList arrayList : edg) {
            arrayList.sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return scores[i2] - scores[i1];
                }
            });
        }
        boolean [] visited = new boolean[scores.length];
        int max = -1;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (edg[a].size()==1||edg[b].size()==1){
                continue;
            }
            visited[a] = true;
            visited[b] = true;
            for (Object o : edg[a]) {
                Integer c = (Integer) o;
                if (visited[c]){
                    continue;
                }
                visited[c]=true;
                for (Object o1 : edg[b]) {
                    Integer d = (Integer) o1;
                    if (visited[d]){
                        continue;
                    }
                    max = Math.max(max,scores[a]+scores[b]+scores[c]+scores[d]);
                    break;
                }
                visited[c] = false;
            }
            visited[a]=false;
            visited[b]=false;
        }
        return max;
    }
}
