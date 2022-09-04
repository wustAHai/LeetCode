package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenz at 9:49 on 2022/6/25 .
 */
public class L515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if (root == null){
            return arr;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0){
                    max= poll.val;
                }else {
                    max = Math.max(poll.val, max);
                }
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            arr.add(max);
        }
        return arr;
    }
}
