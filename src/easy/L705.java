package easy;

import java.util.ArrayList;

/**
 * Created by chenz at 9:44 on 2021/3/13
 */
public class L705 {

}
class MyHashSet {

    ArrayList<Integer>  arrayList;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arrayList  = new ArrayList<>();
    }

    public void add(int key) {
        if (contains(key)){
            return;
        }
        arrayList.add(key);
    }

    public void remove(int key) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)==key){
                arrayList.remove(i);
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)==key){
                return true;
            }
        }
        return false;
    }
}