package contest.The292;

import easy.TreeNode;

/**
 * @author chenz at 17:20 on 2022/5/8 .
 */
public class Solution {
    public String largestGoodInteger(String num) {
        int i = 0;
        char[] chars = num.toCharArray();
        String ans = "";
        while (i+2<num.length()){
            if (chars[i]==chars[i+1]&&chars[i]==chars[i+2]){
                String temp = ""+chars[i]+chars[i]+chars[i];
                if (temp.compareTo(ans)>0){
                    ans = temp;
                }
            }
            i++;
        }
        return ans;
    }

    int  ans = 0;

    public int averageOfSubtree(TreeNode root) {
        getFromChild(root);
        return ans;
    }

    private int[] getFromChild(TreeNode root) {
        if (root == null){
            return new int[]{0,0};
        }
        int[] left = getFromChild(root.left);
        int[] right = getFromChild(root.right);
        if ((right[0]+left[0]+ root.val)/(right[1]+left[1]+1)==root.val){
            ans++;
        }
        return  new int[]{left[0]+right[0]+root.val,right[1]+left[1]+1};
    }
}
