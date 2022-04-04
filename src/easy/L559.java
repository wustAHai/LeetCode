package easy;

import java.util.List;

/**
 * Created by chenz at 9:51 on 2021/1/25
 */
public class L559 {
    int max = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int x = 1;
        maxDepth(root, x);
        return max;
    }

    private void maxDepth(Node root, int x) {
        max = Math.max(x, max);
        for (Node node :
                root.children) {
            maxDepth(node, x + 1);
        }
    }
}

