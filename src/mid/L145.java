package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 15:50 on 2021/1/8
 */
public class L145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }

    private void post(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) {
            post(root.left, list);
        }
        if (root.right != null) {
            post(root.right, list);
        }
        list.add(root.val);
    }

}
