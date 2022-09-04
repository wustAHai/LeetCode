package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 10:09 on 2022/5/1 .
 */
public class L1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        int i = 0;
        int j = 0;
        for (; i < list1.size() && j < list2.size(); ) {
            if (list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }
        if (i == list1.size()) {
            while (j < list2.size()) {
                ans.add(list2.get(j++));
            }
        }
        if (j == list2.size()) {
            while (i < list1.size()) {
                ans.add(list2.get(i++));
            }
        }

        return ans;
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root==null){
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
