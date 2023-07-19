package contest;

import java.util.*;

/**
 * @author chenz at 10:27 on 2022/9/25 .
 */
public class C312 {
    public static void main(String[] args) {
        C312 c312 = new C312();
        c312.goodIndices(new int[]{388589, 17165, 726687, 401298, 600033, 537254, 301052, 151069, 399955}, 4);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] ans = new String[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            ans[heights.length - 1 - i] = map.get(heights[i]);
        }
        return ans;
    }

    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        for (int i = 0; i < nums.length; ) {
            int j = i;
            while (j < nums.length && nums[j] == max) {
                j++;
            }
            ans = Math.max(ans, j - i);
            i = j + 1;
        }
        return ans;
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (k == 1) {
            for (int i = k; i < nums.length - k; i++) {
                list.add(i);
            }
        } else {
            int[] noinc = new int[nums.length - 2 * k];
            int[] nodes = new int[noinc.length];
            for (int i = k; i < nums.length - k; i++) {
                int j = i - k;
                if (j > 0) {
                    if (noinc[j - 1] == 0) {
                        if (nums[i - 2] < nums[i - 1]) {
                            noinc[j] = i - 1;
                        }
                    }else {
                        if (j<noinc[j-1]){
                            noinc[j]=noinc[j-1];
                        }else {
                            for (int l = j; l <= i-1; l++) {
                                if (l+1<=i-1&&nums[l]<nums[l+1]){
                                    noinc[j] = l+1;
                                    break;
                                }
                            }
                        }
                    }
                }else {
                    for (int l = j; l <= i-1; l++) {
                        if (l+1<=i-1&&nums[l]<nums[l+1]){
                            noinc[j] = l+1;
                            break;
                        }
                    }
                }

                if (j > 0) {
                    if (nodes[j - 1] == 0) {
                        if (nums[i +k-1] > nums[i + k]) {
                            nodes[j] = i+k;
                        }
                    }else {
                        if (i+1<nodes[j-1]){
                            nodes[j]=nodes[j-1];
                        }else {
                            for (int l = i+1; l <= i+k; l++) {
                                if (l+1<=i+k&&nums[l]>nums[l+1]){
                                    nodes[j] = l+1;
                                    break;
                                }
                            }
                        }
                    }
                }else {
                    for (int l = i+1; l <= i+k; l++) {
                        if (l+1<=i+k&&nums[l]>nums[l+1]){
                            nodes[j] = l+1;
                            break;
                        }
                    }
                }

            }
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i]==0&&noinc[i]==0){
                    list.add(i+k);
                }
            }
        }
        return list;
    }
}