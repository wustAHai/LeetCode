package easy;

/**
 * Created by chenz at 14:02 on 2021/1/22
 */
public class L530 {
    public int getMinimumDifference(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        getMinimumDifference(root, min);
        return min[0];
    }

    private void getMinimumDifference(TreeNode root, int[] min) {
        if (root == null) {
            return;
        }
        TreeNode temp;
        if (root.left != null) {
            min[0] = Math.min(min[0], root.val - root.left.val);
            temp = root.left.right;
            while (temp != null) {
                min[0] = Math.min(min[0], root.val - temp.val);
                temp = temp.right;
            }
        }
        if (root.right != null) {
            min[0] = Math.min(min[0], root.right.val - root.val);
            temp = root.right.left;
            while (temp != null) {
                min[0] = Math.min(min[0], temp.val - root.val);
                temp = temp.left;
            }
        }
        getMinimumDifference(root.left, min);
        getMinimumDifference(root.right, min);
    }

}
