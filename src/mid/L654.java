package mid;

import easy.TreeNode;

import java.util.Map;

/**
 * @author chenz at 13:03 on 2022/8/20 .
 */
public class L654 {
    int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return getRoot(0,nums.length-1);
    }

    TreeNode getRoot(int s,int e){
        if (s>e){
            return null;
        }
        int maxIndex = getMaxIndex(s, e);
        TreeNode  root = new TreeNode(nums[maxIndex]);
        root.left=getRoot(s,maxIndex-1);
        root.right=getRoot(maxIndex+1,e);
        return root;
    }

   int  getMaxIndex(int s,int e){
        if (s>e){
            return getMaxIndex(e,s);
        }
        int temp = nums[s];
        int ans = s;
       for (int i = s+1; i <=e ; i++) {
           if (temp<nums[i]){
               temp=nums[i];
               ans=i;
           }
       }
       return ans;
   }
    // TODO: 2022/8/20 方法二：单调栈 最优解 
}
