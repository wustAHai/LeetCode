package easy;

/**
 * Created by chenz at 8:01 on 2021/3/5
 */
public class JZ55B {
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;
    }

    private int height(TreeNode root) {
        if (root==null){
            return 0;
        }
        int l = height(root.left);
        if (l==-1){
            return -1;
        }
        int r = height(root.right);
        if (r==-1){
            return -1;
        }
        if (Math.abs(l-r)>1){
            return -1;
        }
        return Math.max(l,r)+1;
    }
}
