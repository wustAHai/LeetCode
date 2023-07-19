package mid;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenz at 18:47 on 2022/9/15 .
 * <a  href="https://leetcode.cn/problems/bulb-switcher-ii/solution/deng-pao-kai-guan-ii-by-leetcode-solutio-he7o/">官解</a>
 */
public class L672 {
    public int flipLights(int n, int presses) {
        if(n==1){
            return 2;
        }else if (n<3){
            if (presses ==1){
                // all  j o
                return 3;
            }else{
                return  4;
            }
        }else if (n==3){
            if (presses ==1){
                //000 010 101 011
                return 4;
            }else if (n==2){
                //111 000 010 101 110 001 100 (011)
                return 7;
            }else{
               return 8;
            }
        }else {
            Set<Integer> set = new HashSet<>();
            set.add(17);
            while (presses>0){
                Set<Integer> tempSet = new HashSet<>();
                for (Integer integer : set) {
                    tempSet.add(integer^17);
                    tempSet.add(integer^9);
                    tempSet.add(integer^10);
                    tempSet.add(integer^5);
                }
                presses--;
                if (set.equals(tempSet)){
                    return set.size();
                }else {
                    set.clear();
                    set = tempSet;
                }
            }
            return set.size();
        }
    }
}
