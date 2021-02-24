package easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenz at 10:32 on 2021/1/30
 */
public class L637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Deque<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.push(root);
            int n = 0;
            while ((n = nodes.size()) > 0) {
                double sum = 0;
                for (int i = 0; i < n; i++) {
                    TreeNode node = nodes.removeFirst();
                    sum += node.val;
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
                list.add(sum / n);
            }
        }
        return list;
    }
}
