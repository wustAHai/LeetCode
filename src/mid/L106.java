package mid;

import easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenz at 15:16 on 2021/1/20
 */
public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1, hashMap, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, Map<Integer, Integer> hashMap, int inoLeft, int inoRight) {
        if (postLeft > postRight || inoLeft > inoRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int index = hashMap.get(postorder[postRight]);
        root.left = buildTree(postorder, postLeft, index - 1 - inoLeft + postLeft, hashMap, inoLeft, index - 1);
        root.right = buildTree(postorder, index - inoLeft + postLeft, postRight - 1, hashMap, index + 1, inoRight);
        return root;
    }
}
