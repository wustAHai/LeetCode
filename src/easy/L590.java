package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 21:02 on 2021/1/27
 */
public class L590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            postorder(root, list);
        }
        return list;
    }

    private void postorder(Node root, List<Integer> list) {
        for (Node node :
                root.children) {
            postorder(node, list);
        }
        list.add(root.val);
    }
}
