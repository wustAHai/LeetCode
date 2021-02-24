package mid;

import easy.TreeNode;

import java.util.*;

/**
 * Created by chenz at 22:56 on 2021/1/27
 */
public class L199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int n = deque.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = deque.removeFirst();
                    if (node.left != null)
                        deque.add(node.left);
                    if (node.right != null)
                        deque.add(node.right);
                    if (i == n - 1) {
                        integerList.add(node.val);
                    }
                }
            }
        }
        return integerList;
    }
}
