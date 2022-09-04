package mid;

/**
 * @author chenz at 19:34 on 2022/8/15 .
 */
public class L641 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(2);
        myCircularDeque.insertFront(7);
        myCircularDeque.deleteLast();
        myCircularDeque.getFront();
        myCircularDeque.insertFront(5);
        myCircularDeque.insertFront(0);
        myCircularDeque.getRear();
    }
}

class MyCircularDeque {
    int size = 0;
    int[]arr;
    int q=0;
    int p;

    public MyCircularDeque(int k) {
        arr = new int[k];
        p=k-1;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        size++;
        arr[p]=value;
        p=(p-1+arr.length)%arr.length;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        size++;
        arr[q++] = value;
        q=q%arr.length;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        size--;
        p=(p+1)%arr.length;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        size--;
        q= (q-1+arr.length)%arr.length;
        return true;
    }
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[(p+1)%arr.length];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(q-1+arr.length)%arr.length];
    }

    public boolean isEmpty() {
        return size ==0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
    void  fun(){

    }
}
