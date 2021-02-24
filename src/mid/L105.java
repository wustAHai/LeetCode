package mid;

import easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenz at 15:57 on 2021/1/8
 */
public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, hashMap, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> hashMap, int inoLeft, int inoRight) {
        if (preLeft > preRight || inoLeft > inoRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = hashMap.get(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, index - inoLeft + preLeft, hashMap, inoLeft, index - 1);
        root.right = buildTree(preorder, index - inoLeft + preLeft + 1, preRight, hashMap, index + 1, inoRight);
        return root;
    }

}
