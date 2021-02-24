package easy;

import java.util.HashMap;

/**
 * Created by chenz at 8:46 on 2021/2/2
 */
public class JZ07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length - 1;
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorderMap, 0, length);
    }

    private TreeNode buildTree(int[] preorder, int head, HashMap<Integer, Integer> inorderMap, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[head]);
        int index = inorderMap.get(preorder[head]);
        int leftLength = index - left;
        int rightLength = right - index;
        root.left = buildTree(preorder, head + 1, inorderMap, left, index - 1);
        root.right = buildTree(preorder, head + leftLength, inorderMap, index + 1, right);
        return root;
    }
}
