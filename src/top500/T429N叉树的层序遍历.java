package top500;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenz at 18:42 on 2022/4/8 .
 */
public class T429N叉树的层序遍历 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root==null){
            return ans;
        }
        queue.add(root);
        int n;
        while ((n = queue.size())>0){
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node poll = queue.poll();
                a.add(poll.val);
                List<Node> children = poll.children;
                if (children!=null){
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
            }
            ans.add(a);
        }
        return ans;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}