package mid;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenz at 19:27 on 2022/7/5 .
 */
public class L729 {
    static class MyCalendar {
        TreeMap<Integer,Integer> map  = new TreeMap<>();
        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            if (map.containsKey(start)){
                return false;
            }
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);
            if (ceilingEntry!=null&&ceilingEntry.getKey()<end){
                return false;
            }
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
            if (floorEntry!=null&&floorEntry.getValue()>start){
                return false;
            }
            map.put(start,end);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(19,25);
        System.out.println(myCalendar.book(18,27));
    }
}
