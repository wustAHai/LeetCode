package mid;

import easy.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenz at 20:31 on 2022/7/25 .
 */
public class L919 {

}

class CBTInserter {

    Deque<TreeNode> deque = new LinkedList<>();
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode peek = deque.peek();
            if (peek.left != null) {
                deque.addLast(peek.left);
            }
            if (peek.right != null) {
                deque.addLast(peek.right);
                deque.poll();
            }
            if (peek.left==null||peek.right==null){
                break;
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        deque.addLast(node);
        TreeNode peek = deque.peek();
        if (peek.left == null) {
            peek.left = node;
        }
        if (peek.right == null) {
            peek.right = node;
        }
        deque.poll();
        return peek.val;

    }

    public TreeNode get_root() {
        return root;
    }
}
