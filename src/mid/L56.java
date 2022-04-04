package mid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenz on 2020/12/29 10:29
 */
public class L56 { //int[] 也是一种对象可以操作
    class Range {
        int s;
        int e;

        Range(int a, int b) {
            s = a;
            e = b;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        List<Range> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Range(intervals[i][0], intervals[i][1]));
        }
        list.sort((a, b) -> a.s - b.s);
        LinkedList<Range> result = new LinkedList<>();
        result.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            ;
            Range last = result.pollLast();
            Range in = list.get(i);
            if (in.s <= last.e) {
                last.e = Math.max(in.e, last.e);
                result.add(last);
            } else {
                result.add(last);
                result.add(in);
            }
        }
        int[][] r = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            Range range = result.get(i);
            r[i][0] = range.s;
            r[i][1] = range.e;
        }
        return r;
    }
}
