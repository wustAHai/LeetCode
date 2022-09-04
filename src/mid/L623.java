package mid;

import easy.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenz at 18:59 on 2022/8/5 .
 */
public class L623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        int level = 1;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            if (level == depth) {
                while (size > 0) {
                    TreeNode poll = deque.poll();
                    TreeNode node = new TreeNode(val);
                    node.left = poll.left;
                    poll.left = node;
                    node = new TreeNode(val);
                    node.right = poll.right;
                    poll.right = node;
                    size--;
                }
                return root;
            }
            while (size > 0) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
                size--;
            }
        }
        return root;
    }
}
