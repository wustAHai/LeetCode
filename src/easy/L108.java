package easy;

/**
 * Created by chenz at 16:03 on 2021/1/12
 */
public class L108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        TreeNode root = new TreeNode(nums[n / 2]);
        sort(root, nums, 0, n / 2 - 1, n / 2 + 1, n - 1);
        return root;
    }

    private void sort(TreeNode root, int[] nums, int i, int i1, int i2, int i3) {
        if (i <= i1) {
            root.left = new TreeNode(nums[(i + i1) / 2]);
            sort(root.left, nums, i, (i + i1) / 2 - 1, (i + i1) / 2 + 1, i1);
        } else {
            root.left = null;
        }
        if (i2 <= i3) {
            root.right = new TreeNode((nums[(i2 + i3) / 2]));
            sort(root.right, nums, i2, (i2 + i3) / 2 - 1, (i2 + i3) / 2 + 1, i3);
        } else {
            root.right = null;
        }
    }

}
