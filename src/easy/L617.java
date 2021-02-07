package easy;

/**
 * Created by chenz at 22:01 on 2021/1/29
 */
public class L617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = new TreeNode();
        if (t1==null&&t2==null){
            return null;
        }
        if (t1!=null&&t2!=null){
            root.val=t1.val+ t2.val;
            root.left=mergeTrees(t1.left,t2.left);
            root.right=mergeTrees(t1.right,t2.right);
        }
        if (t1==null&&t2!=null){
            root.val= t2.val;
            root.left=t2.left;
            root.right=t2.right;
        }
        if (t1!=null&&t2==null){
            root.val= t1.val;
            root.left=t1.left;
            root.right=t1.right;
        }
        return root;
    }
}
