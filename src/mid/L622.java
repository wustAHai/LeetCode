package mid;

/**
 * @author chenz at 18:40 on 2022/8/2 .
 */
public class L622 {

}
class MyCircularQueue {

    int[] arr;
    int size;
    int maxSize;
    int p;
    int q;
    public MyCircularQueue(int k) {
        arr = new int[k];
        maxSize = k;
    }

    public boolean enQueue(int value) {
        if (size==maxSize){
            return false;
        }
        arr[q++]=value;
        q%=maxSize;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size==0) {
            return false;
        }
        p++;
        p%=maxSize;
        size--;
        return true;
    }

    public int Front() {
        if (size==0){
            return -1;
        }
        return arr[p];
    }

    public int Rear() {
        if (size==0){
            return -1;
        }
        return arr[(q+maxSize-1)%maxSize];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==maxSize;
    }
}