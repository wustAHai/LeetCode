package easy;

/**
 * Created by chenz at 22:01 on 2021/1/29
 */
public class L617 {
/*    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = new TreeNode();
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 != null && t2 != null) {
            root.val = t1.val + t2.val;
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        if (t1 == null && t2 != null) {
            root.val = t2.val;
            root.left = t2.left;
            root.right = t2.right;
        }
        if (t1 != null && t2 == null) {
            root.val = t1.val;
            root.left = t1.left;
            root.right = t1.right;
        }
        return root;
    }*/

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return  root1;
    }



}
