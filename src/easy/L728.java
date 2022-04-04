package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 20:14 on 2022/3/31 .
 */
public class L728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            if (yes(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    boolean yes(int i){
        if (i==0){
            return false;
        }
        int temp=i;
        while (temp>0){
            int b = temp%10;
            if (b==0){
                return false;
            }else {
                if (i%b!=0){
                    return false;
                }
            }
            temp/=10;
        }
        return true;
    }
}
