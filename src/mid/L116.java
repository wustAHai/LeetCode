package mid;

import java.util.LinkedList;
import java.util.Queue;

public class L116 {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node poll = queue.poll();
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
            size--;
            while (size>0){
                poll.next = queue.poll();
                poll = poll.next;
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
        }
        return root;
    }
}
