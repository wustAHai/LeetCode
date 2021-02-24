package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 10:36 on 2021/1/8
 */
public class L144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
