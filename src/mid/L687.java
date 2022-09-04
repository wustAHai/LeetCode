package mid;

import easy.TreeNode;

/**
 * @author chenz at 18:40 on 2022/9/2 .
 * <a href="https://leetcode.cn/problems/longest-univalue-path/solution/zui-chang-tong-zhi-lu-jing-by-leetcode-s-hgfk/">最优解</a>
 */
public class L687 {


    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs1(root);
        return max;
    }
    void  dfs1(TreeNode root){
        if (root==null){
            return;
        }else {
            max= Math.max(dfs(root),max);
            dfs1(root.left);
            dfs1(root.right);
        }
    }

    int   dfs(TreeNode root){
        if (root == null){
            return  0;
        }
        return  dfs(root.left,root.val) + dfs(root.right,root.val);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null||root.val != val){
            return  0;
        }
        return 1 + Math.max(dfs(root.left,val),dfs(root.right,val));
    }
}
