package easy;

/**
 * Created by chenz at 16:58 on 2021/1/25
 */
public class L563 {
    int tilt = 0;

    public int findTilt(TreeNode root) {
        doJob(root);
        return tilt;
    }

    private int doJob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int x = doJob(root.left);
        int y = doJob(root.right);
        tilt += Math.abs(x - y);
        return x + y + root.val;
    }
}
