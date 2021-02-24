package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        if (root != null) {
            temp.add(root);
        }
        int level = 1;
        levelOrder(listList, temp, level);
        return listList;
    }

    public void levelOrder(List<List<Integer>> listList, List<TreeNode> temp, int level) {
        int size = temp.size();
        if (size == 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = temp.remove(0);
            if (level % 2 == 1) {
                arrayList.add(treeNode.val);
            } else {
                arrayList.add(0, treeNode.val);
            }

            if (treeNode.left != null) {
                temp.add(treeNode.left);
            }
            if (treeNode.right != null) {
                temp.add(treeNode.right);
            }
        }
        listList.add(arrayList);
        levelOrder(listList, temp, ++level);
    }
}


