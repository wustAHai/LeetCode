package mid;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenz at 20:46 on 2022/7/19 .
 */
public class L731 {
    public static void main(String[] args) {


        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        int[][] arr= new int[][] {{69,78},{81,86},{80,87},{58,66},{40,46},{81,88},{40,47},{18,25},{52,59},{80,88},{58,63},{15,21},{79,87},{77,83},{9,14},{67,76},{39,44},{36,45},{11,20},{61,69},{51,60},{49,57},{48,53},{2,8},{8,15},{49,57},{8,16},{42,51},{94,100},{44,50},{1,9},{69,78},{47,53},{98,100},{56,62},{26,31},{3,9},{68,75},{85,92},{52,57},{51,59},{18,26},{60,65},{92,99},{90,98},{89,97},{39,44},{31,39},{90,96},{44,49},{44,49},{47,54},{24,32},{59,68},{29,34},{38,43},{3,8},{98,100},{48,57},{19,24},{65,71},{20,29},{18,23},{67,76},{78,86},{43,48},{30,39},{49,56},{48,56},{84,91},{13,18},{96,100},{31,36},{1,8},{90,97},{96,100},{20,28},{45,52},{1,6},{13,22}};
        int i = 0;
        System.out.println(arr.length);
        for (int[] ints : arr) {
            boolean book = myCalendarTwo.book(ints[0], ints[1]);
            System.out.println("----------"+ i++ +"----------------");
            System.out.println("  {"+ints[0]+"  , "+ints[1]+ " }");
            if (book){
                System.out.println(myCalendarTwo.map1);
                System.out.println(myCalendarTwo.map2);
            }
        }
    }
}
/**
 * 1 10
 * 10 18
 * 15 23   15 18
 * 20 27   20 23
 * 27 36   27 36
 * 40 47
 * 47 50
 *
 */
class MyCalendarTwo {
    TreeMap<Integer, Integer> map1;
    TreeMap<Integer, Integer> map2;

    public MyCalendarTwo() {
        map1 = new TreeMap<>();
        map2 = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (isJoin(map2, start, end)) {
            return false;
        }
        if (!isJoin(map1, start, end)) {
            map1.put(start, end);
            return true;
        }
        if (map1.containsKey(start)) {
            Integer integer = map1.get(start);
            map1.merge(start, Math.max(end, integer), (a, b) -> Math.max(b, a));
            map2.merge(start, Math.min(end, integer), (a, b) -> Math.max(b, a));
        }
        map1.merge(start,end, (a, b) -> Math.max(b, a));
        Map.Entry<Integer, Integer> higherEntry = map1.higherEntry(start);
        while (higherEntry != null) {
            Integer higherEntryValue = higherEntry.getValue();
            Integer higherEntryKey = higherEntry.getKey();
            if (higherEntryKey < end) {
                map1.merge(higherEntryKey, Math.max(higherEntryValue, end), (a, b) -> Math.max(b, a));
                map1.merge(start, Math.max(higherEntryValue, end), (a, b) -> Math.max(b, a));
                map2.merge(higherEntryKey, Math.min(higherEntryValue, end), (a, b) -> Math.max(b, a));
            }else {
                break;
            }
            higherEntry = map1.higherEntry(higherEntryKey);
        }

        Map.Entry<Integer, Integer> lowerEntry = map1.lowerEntry(start);
        while (lowerEntry != null) {
            Integer lowerEntryKey = lowerEntry.getKey();
            Integer lowerEntryValue = lowerEntry.getValue();
            if (lowerEntryValue > start) {
                map1.merge(start, Math.max(lowerEntryValue, end), (a, b) -> Math.max(b, a));
                map1.merge(lowerEntryKey, Math.max(lowerEntryValue, end), (a, b) -> Math.max(b, a));
                map2.merge(start,Math.min(end,lowerEntryValue),(a, b) -> Math.max(b, a));
            }else {
                break;
            }
            lowerEntry = map1.lowerEntry(lowerEntryKey);
        }
        return true;
    }

    boolean isJoin(TreeMap<Integer, Integer> map, int start, int end) {
        if (map.containsKey(start)) {
            return true;
        }
        Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(start);
        if (lowerEntry != null) {
            if (lowerEntry.getValue() > start) {
                return true;
            }
        }
        Integer higherKey = map.higherKey(start);
        if (higherKey != null) {
            if (higherKey < end) {
                return true;
            }
        }
        return false;
    }
}