package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenz at 1:10 on 2023/4/15 .
 */
public class L1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] arr = new  int[n];
        List<Integer>[] edg  = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edg[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            edg[path[0]-1].add(path[1]-1);
            edg[path[1]-1].add(path[0]-1);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> e = edg[i];
            if (e.isEmpty()) {
                arr[i] = 1;
            }else {
                int status = 0;
                for (Integer integer : e) {
                    if (arr[integer]!=0){
                        status|=1<<arr[integer];
                    }
                }
                for (int j = 1; j <= 4; j++) {
                    if ((status&1<<j)==0){
                        arr[i]=j;
                        break;
                    }
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int i = 2;
        i|=1<<1;
        i|=1<<2;
        System.out.println(i&1<<1);
    }
    public int[] findColumnWidth(int[][] grid) {
        int[] ret = new int[grid[0].length];
        for(int j = 0;j<ret.length;j++){
            for(int i = 0 ; i<grid.length;i++){
                ret[j] = Math.max(ret[j],String.valueOf(grid[i][j]).length());
            }
        }
        return ret;
    }

    public long[] findPrefixScore(int[] nums) {
        long[] ret = new long[nums.length];
        long max = nums[0];
        ret[0] = nums[0]<<1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            ret[i] = max+nums[i]+ ret[i-1];
        }
        return ret;
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode[]> deque = new LinkedList<>();
        int newSum = root.val;
        deque.push(new TreeNode[]{root});
        int preSum = 0;
        while (!deque.isEmpty()){
            preSum = newSum;
            newSum = 0;
            int length = deque.size();
            for (int i = 0; i < length; i++) {
                TreeNode[] poll = deque.poll();
                int tempSum = 0;
                for (TreeNode node : poll) {
                    tempSum+=node.val;
                }
                for (TreeNode node : poll) {
                    node.val = preSum-tempSum;
                    if (node.left!=null&&node.right!=null){
                        newSum+=node.left.val+node.right.val;
                        deque.offer(new TreeNode[]{node.left,node.right});
                    }else if (node.left!=null){
                        newSum+=node.left.val;
                        deque.offer(new TreeNode[]{node.left});
                    }else if (node.right!=null){
                        newSum+=node.right.val;
                        deque.offer(new TreeNode[]{node.right});
                    }
                }
            }
        }
        return root;
    }
}
