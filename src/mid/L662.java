package mid;

import easy.TreeNode;

import java.util.LinkedList;

/**
 * @author chenz at 15:34 on 2022/8/27 .
 */
public class L662 {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        root.val = 1;
        list.add(root);
        while (!list.isEmpty()) {
            LinkedList<TreeNode> sonList = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if (node.left != null || node.right != null) {
                    if (node.left != null) {
                        node.left.val = node.val * 2;
                        sonList.add(node.left);
                    }
                    if (node.right != null) {
                        node.right.val = node.val * 2 + 1;
                        sonList.add(node.right);
                    }
                }
            }
            if (!sonList.isEmpty()){
                max = Math.max(sonList.getLast().val - sonList.get(0).val + 1, max);
            }
            list.clear();
            list = sonList;
        }
        return max;
    }
}
