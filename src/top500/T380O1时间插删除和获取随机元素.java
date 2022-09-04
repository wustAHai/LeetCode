package top500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenz at 22:20 on 2022/4/13 .
 */
public class T380O1时间插删除和获取随机元素 {
    class RandomizedSet {
        List<Integer> list;
        Map<Integer,Integer> map;
        int size ;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            map.put(val,size++);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)){
                int i = map.get(val);
                Integer integer = list.get(--size);
                list.set(i,integer);
                map.put(integer,i);
                map.remove(val);
                list.remove(size);
                return true;
            }else {
                return false;
            }
        }

        public int getRandom() {
          return  list.get((int) (Math.random()*size));
        }
    }
}
