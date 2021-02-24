package easy;

/**
 * Created by chenz at 23:23 on 2021/1/30
 */
public class L653 {
    public boolean findTarget(TreeNode root, int k) {
        return preOrder(root, root, k);
    }

    private boolean find(TreeNode root, int temp, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == temp) {
            if (k - temp != temp) {
                return true;
            } else {
                return false;
            }
        } else if (temp > root.val) {
            return find(root.right, temp, k);
        } else {
            return find(root.left, temp, k);
        }
    }

    private boolean preOrder(TreeNode root, TreeNode temp, int k) {
        if (temp == null) {
            return false;
        }
        return find(root, k - temp.val, k) || preOrder(root, temp.left, k) || preOrder(root, temp.right, k);
    }
}
