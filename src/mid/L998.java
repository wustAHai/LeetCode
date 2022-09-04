package mid;

import easy.TreeNode;

/**
 * @author chenz at 18:44 on 2022/8/30 .
 */
public class L998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node  = new TreeNode(val);
        if (val>root.val){
            node.left = root;
            return  node;
        }
        TreeNode temp = root;
        while (true){
            if (temp.right==null){
                temp.right=node;
                return root;
            }else {
                if (temp.right.val<val){
                    node.left=temp.right;
                    temp.right = node;
                    return root;
                }else {
                    temp = temp.right;
                }
            }
        }
    }
}
