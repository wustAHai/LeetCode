package easy;

/**
 * Created by chenz at 19:29 on 2021/2/13
 */
public class L700 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
