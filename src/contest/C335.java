package contest;

import easy.TreeNode;

import java.util.*;

/**
 * @author chenz at 10:29 on 2023/3/5 .
 */
public class C335 {
    // n=4 6 n=3  4
    public int passThePillow(int n, int time) {
        int ans = 1;
        time%=(n*2-2);
        if(time>=n-1){
            return n-(time-n+1);
        }else {
            return  1+time;
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        List<Long> list = new ArrayList<>();
        while (!deque.isEmpty()){
            int size = deque.size();
            long l = 0l;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                l+= poll.val;
                if (poll.left!=null){
                    deque.offer(poll.left);
                }
                if (poll.right!=null){
                    deque.offer(poll.right);
                }
            }
            list.add(l);
        }
        if (k>list.size()){
            return  -1;
        }
        list.sort(Comparator.reverseOrder());
        return list.get(k-1);
    }

    public int findValidSplit(int[] nums) {
        int max = 0;
        int i = 0;
        for (; i < nums.length&&i<=max; i++) {
            int j  = nums.length-1;
            while (j>i&&j>max&&gcd(nums[i],nums[j])==1){
                j--;
            }
            max=Math.max(max,j);
            if (max==nums.length-1){
                return -1;
            }
        }
        if (i>max){
            return max;
        }
        return -1;
    }
    int gcd(int a,int b){
        int mod = a%b;
        while (mod!=0){
            a=b;
            b=mod;
            mod=a%b;
        }
        return b;
    }

    public int waysToReachTarget(int target, int[][] types) {
        int[] f = new int[target+1];
        f[0] = 1;
        for (int[] type : types) {
            int count = type[0];
            int mark = type[1];
            for (int i = target; i >0 ; i--) {
                for (int j = 1; j <= i/mark&&j<=count ; j++) {
                    f[i]=(f[i]+f[i-j*mark])%1000000007;
                }
            }
        }
        return f[target];
    }
}
