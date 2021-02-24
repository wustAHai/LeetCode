package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenz at 10:30 on 2021/1/29
 */
public class L599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> hash1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hash1.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (hash1.containsKey(list2[i])) {
                if (i + hash1.get(list2[i]) < min) {
                    arrayList.clear();
                    min = i + hash1.get(list2[i]);
                    arrayList.add(list2[i]);
                } else if (i + hash1.get(list2[i]) == min) {
                    arrayList.add(list2[i]);
                }
            }
        }
        String[] arr = new String[arrayList.size()];
        arrayList.toArray(arr);
        return arr;
    }
}
