package easy;

/**
 * Created by chenz at 13:17 on 2021/1/26
 */
public class L572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (isSame(s, t)) {
            return true;
        } else {
            if (s != null) {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            } else {
                return t == null;
            }
        }
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null) {
            if (s.val != t.val) {
                return false;
            } else {
                return isSame(s.left, t.left) && isSame(s.right, t.right);
            }
        }
        return false;
    }
}
