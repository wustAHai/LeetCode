package mid;

import easy.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenz at 13:12 on 2022/7/31 .
 */
public class L1161 {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int sum = root.val;
        int level = 0;
        int ans = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            level++;
            int tempSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                tempSum+=poll.val;
                if (poll.left!=null){
                    deque.addLast(poll.left);
                }
                if (poll.right!=null){
                    deque.addLast(poll.right);
                }
            }
            if (tempSum>sum){
                ans=level;
                sum=tempSum;
            }
        }
        return ans;
    }
}
