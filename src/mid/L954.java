package mid;

import java.util.TreeMap;

/**
 * @author chenz at 10:55 on 2022/4/1 .
 */
public class L954 {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while (!map.isEmpty()){
            int i = map.firstKey();
            if (i<0){
                if (i%2!=0){
                    return false;
                }else {
                    int integer = map.getOrDefault(i / 2,0);
                     int ii = map.get(i);
                    if (ii>integer){
                        return false;
                    }
                    map.remove(i);
                    if (ii==integer){
                        map.remove(i/2);
                    }else {
                        map.put(i/2,integer-ii);
                    }
                }
            }else if (i==0){
                if (map.get(i)%2!=0){
                    return false;
                }
                map.remove(i);
            }else {
                int integer = map.getOrDefault(i *2,0);
                int ii = map.get(i);
                if (ii>integer){
                    return false;
                }
                map.remove(i);
                if (ii==integer){
                    map.remove(i*2);
                }else {
                    map.put(i*2,integer-i);
                }
            }
        }
        return true;
    }
}
