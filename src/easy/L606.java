package easy;

/**
 * Created by chenz at 22:51 on 2021/1/29
 */
public class L606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        tree2str(t, sb);
        return sb.toString();
    }

    private void tree2str(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if (t.left == null && t.right == null) {
            return;
        }
        if (t.left != null && t.right != null) {
            sb.append("(");
            tree2str(t.left, sb);
            sb.append(")");
            sb.append("(");
            tree2str(t.right, sb);
            sb.append(")");
        }
        if (t.left == null && t.right != null) {
            sb.append("()");
            sb.append("(");
            tree2str(t.right, sb);
            sb.append(")");
        }
        if (t.left != null && t.right == null) {
            sb.append("(");
            tree2str(t.left, sb);
            sb.append(")");
        }
    }
}
