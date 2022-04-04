package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz on 2020/12/23 9:27
 */
public class L257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        StringBuilder stringBuilder = new StringBuilder();
        addPath(list, stringBuilder, root);
        return list;
    }

    public void addPath(List<String> list, StringBuilder stringBuilder, TreeNode treeNode) {
        stringBuilder.append(treeNode.val);
        if (treeNode.left != null) {
            stringBuilder.append("->");
            addPath(list, stringBuilder, treeNode.left);
            stringBuilder.delete(stringBuilder.length() - getNum(treeNode.left.val), stringBuilder.length());
        }
        if (treeNode.right != null) {
            stringBuilder.append("->");
            addPath(list, stringBuilder, treeNode.right);
            stringBuilder.delete(stringBuilder.length() - getNum(treeNode.right.val), stringBuilder.length());
        }
        if (treeNode.left == null && treeNode.right == null) {
            list.add(stringBuilder.toString());
        }
    }

    public int getNum(int n) {
        int num = 2;
        if (n == 0) {
            return 3;
        } else if (n > 0) {
            while (n > 0) {
                num++;
                n /= 10;
            }
            return num;
        } else {
            return getNum(-n) + 1;
        }
    }
}
