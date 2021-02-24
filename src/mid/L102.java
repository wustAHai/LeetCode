package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenz on 2020/12/27 9:38
 */
public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        Deque<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        while (treeNodeList.size() > 0) {
            int length = treeNodeList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = treeNodeList.poll();
                if (treeNode.left != null) {
                    treeNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeList.add(treeNode.right);
                }
                list.add(treeNode.val);
            }
            listList.add(list);
        }
        return listList;
    }

}
