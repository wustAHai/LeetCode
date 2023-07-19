package contest;

import java.util.HashSet;

/**
 * @author chenz at 10:34 on 2022/10/16 .
 */
public class L315 {
    public int findMaxK(int[] nums) {
        int[] arr =new int[1001];
        for (int num : nums) {
            if (num>0){
                arr[num]|=1;
            }else {
                arr[-num]|=2;
            }
        }
        for (int i = arr.length; i >=1 ; i--) {
            if (arr[i]==3){
                return i;
            }
        }
        return -1;
    }

    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(reverse(num));
        }
        return set.size();
    }
    int reverse(int i){
        int num = 0;
        while (i>0){
            num*=10;
            num+=i%10;
            i/=10;
        }
        return num;
    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i+reverse(i)==num){
                return true;
            }
        }
        return false;
    }
}
