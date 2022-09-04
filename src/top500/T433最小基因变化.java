package top500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 18:52 on 2022/5/7 .
 */
public class T433最小基因变化 {
    public int minMutation(String start, String end, String[] bank) {
        int index = -1;
        for (int i = 0; i < bank.length; i++) {
            if (bank[i].equals(end)){
                index = i;
                break;
            }
        }
        if (index == -1){
            return  -1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(index);
        boolean[] visit = new boolean[bank.length];
        visit[index] = true;
        int level = 0;
        while (!list.isEmpty()){
            level++;
            List<Integer> temp = list;
            list = new ArrayList<>();
            for (Integer integer : temp) {
                if (check(bank[integer],start)){
                    return level;
                }
                for (int i = 0; i < bank.length; i++) {
                    if (!visit[i]&&check(bank[integer],bank[i])){
                        list.add(i);
                    }
                }
            }
        }
        return -1;
    }
    boolean check(String s1 ,String s2){
        int n = 0;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i)!= s2.charAt(i)){
                n++;
            }
        }
        return n==1;
    }
}
