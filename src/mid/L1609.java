package mid;

import easy.TreeNode;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenz at 10:22 on 2021/12/25 .
 */
public class L1609 {
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int leftVal = 0;
            int rightVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                leftVal = rightVal;
                rightVal = poll.val;
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                if (level%2==0){
                    if (rightVal%2==0 || leftVal>=rightVal){
                        return false;
                    }
                }else {
                    if (rightVal%2==1 || leftVal>0&&leftVal<=rightVal){
                        return  false;
                    }
                }
            }
            level++;
        }
        return true;
    }
}
