package easy;

import java.util.ArrayList;

public class L671 {
    int ans;
    int rootVal;
    public int findSecondMinimumValue(TreeNode root) {
        ans = - 1;
        rootVal = root.val;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        if (ans != -1 && root.val >= ans){
            return;
        }
        if (root.val > rootVal){
            ans = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
