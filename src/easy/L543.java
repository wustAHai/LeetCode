package easy;

/**
 * Created by chenz at 10:01 on 2021/1/23
 */
public class L543 {
    private int num;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTree1(root);
        return num;
    }

    private int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree1(root.left);
        int right = diameterOfBinaryTree1(root.right);
        num = Math.max(num, left + right);
        return Math.max(left, right) + 1;
    }
}
