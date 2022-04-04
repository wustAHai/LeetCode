package easy;

/**
 * Created by chenz at 16:39 on 2021/1/3
 */
public class L404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] sum = {0};
        leftLeaves(root, sum);
        return sum[0];
    }

    public void leftLeaves(TreeNode root, int[] sum) {
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum[0] += root.left.val;
            } else {
                leftLeaves(root.left, sum);
            }
        }
        if (root.right != null) {
            leftLeaves(root.right, sum);
        }
    }

}
