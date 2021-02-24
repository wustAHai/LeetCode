package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenz at 8:00 on 2021/2/9
 */
public class JZ32B {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.addLast(root);
        }
        int n;
        while ((n = deque.size()) > 0) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = deque.removeFirst();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}
