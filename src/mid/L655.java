package mid;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 19:47 on 2022/8/23 .
 */
public class L655 {
    int h;
    public List<List<String>> printTree(TreeNode root) {
        int m = height(root);
        h = m-1;
        List<List<String>> list = new ArrayList<>(m);
        int n =  (1<<m)-1;
        for (int i = 0; i<m; i++) {
            List<String> list1 = new ArrayList<>(n);
            for (int i1 = 0; i1 <n; i1++) {
                list1.add("");
            }
            list.add(list1);
        }
        dfs(0,(n-1)/2,root,list);
        return list;
    }
    void dfs(int i,int j,TreeNode root,List<List<String>> list){
        if (root == null){
            return;
        }
        List<String> list1 = list.get(i);
        list1.set(j,""+root.val);
        dfs(i+1,j-(1<<(h-i-1)),root.left,list);
        dfs(i+1,j+(1<<(h-i-1)),root.right,list);
    }

    int height(TreeNode root){
        if (root==null){
            return 0;
        }
        return  Math.max(height(root.left),height(root.right))+1;
    }

    public static void main(String[] args) {
        System.out.println((1<<3)-1);
    }
}
