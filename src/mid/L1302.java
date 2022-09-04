package mid;

import easy.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenz at 21:17 on 2022/8/17 .
 */
public class L1302 {
    public int deepestLeavesSum(TreeNode root) {
        int sum =0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            sum = 0;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                sum+=poll.val;
                if (poll.left!=null){
                    deque.addLast(poll.left);
                }
                if (poll.right!=null){
                    deque.addLast(poll.right);
                }
            }
        }
        return sum;
    }
}
