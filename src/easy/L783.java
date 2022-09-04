package easy;

import java.util.Stack;

/**
 * @author chenz at 20:52 on 2022/7/18 .
 */
public class L783 {
    int min = Integer.MAX_VALUE;
    int pre = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }
    void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        if (pre!=-1){
            min = Math.min(min,Math.abs(root.val-pre));
        }
        pre = root.val;
        dfs(root.right);
    }
}
