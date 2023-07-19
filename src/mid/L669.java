package mid;

import easy.TreeNode;

/**
 * @author chenz at 12:54 on 2022/9/10 .
 */
public class L669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root!=null && (root.val < low||root.val>high) ) {
            if (root.val>high){
                root = root.left;
            }else if (root.val<low){
                root = root.right;
            }
        }
        if (root == null) {
            return null;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;

    }
}
