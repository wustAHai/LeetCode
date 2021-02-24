package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 15:37 on 2021/1/27
 */
public class L589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node node :
                root.children) {
            preorder(node, list);
        }
    }

}
