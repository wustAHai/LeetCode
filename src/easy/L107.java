package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        treeNodeQueue.add(root);
        while (treeNodeQueue.size() > 0) {
            List<Integer> tmp = new LinkedList<>();
            Queue<TreeNode> sonNodes = new LinkedList<>();
            TreeNode p = treeNodeQueue.poll();
            while (p != null) {
                tmp.add(p.val);
                if (p.left != null) sonNodes.add(p.left);
                if (p.right != null) sonNodes.add(p.right);
                p = treeNodeQueue.poll();
            }
            res.add(0, tmp);
            treeNodeQueue = sonNodes;
        }
        return res;
    }
}
