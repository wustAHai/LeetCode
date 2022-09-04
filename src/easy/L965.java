package easy;

/**
 * @author chenz at 18:41 on 2022/5/26 .
 */
public class L965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.right!=null){
            if (root.right.val!=root.val){
                return false;
            }
        }
        if (root.left!=null){
            if (root.left.val!=root.val){
                return false;
            }
        }
        return isUnivalTree(root.left)&&isUnivalTree(root.right);
    }
}
