package top500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 22:07 on 2022/4/18 .
 */
public class T386字典序排数 {
    //1 10 100 1001 1002 1009 101 1010
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans  = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            ans.add(num);
            if (num*10<=n){
                num*=10;
            }else {
                while (num%10==9||num+1>n){
                    num/=10;
                }
                num++;
            }
        }
        return ans;
    }
}
