package easy;

/**
 * @author chenz at 22:06 on 2022/5/30 .
 */
public class L1022 {

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeave(root)) {
            return root.val;
        }
        if (root.left != null) {
            root.left.val += root.val * 2;
        }
        if (root.right != null) {
            root.right.val += root.val*2;
        }
        return  sumRootToLeaf(root.right) + sumRootToLeaf(root.left);
    }

    boolean isLeave(TreeNode node) {
        return node.right == null && node.left == null;
    }
}
