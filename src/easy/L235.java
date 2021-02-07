package easy;

public class L235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        TreeNode res = root;
        if (p.val < root.val && q.val < root.val) {
            res = lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            res = lowestCommonAncestor(root.right, p, q);
        }
        return res;
    }
}
