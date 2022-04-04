package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 10:27 on 2022/2/19 .
 */
public class L969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int n = arr.length -1 ; n >0 ; n--) {
            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[index]<arr[i]){
                    index = i;
                }
            }
            if (index == n){
                continue;
            }
            ans.add(index+1);
            ans.add(n+1);
            reverse(arr,index);
            reverse(arr,n);
        }
        return ans;
    }
    private void reverse(int[] arr,int k){
        for (int i = 0; i <= k/2; i++) {
            int temp = arr[i];
            arr[i] = arr[k-i];
            arr[k-i] = temp;
        }
    }

    public static void main(String[] args) {
        L969 l969 = new L969();
        int [] arr = {3,2,4,1};
        l969.pancakeSort(arr);
    }
}
