package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenz at 8:10 on 2021/2/11
 */
public class L703 {
    /*    class KthLargest {//双百分之五
            int k;
            List<Integer> arr=new ArrayList<>();
            public KthLargest(int k, int[] nums) {
                this.k=k;
                for (int i = 0; i < nums.length; i++) {
                    arr.add(nums[i]);
                }
            }
            public int add(int val) {
                arr.add(val);
                arr.sort(null);
                return arr.get(arr.size()-k);
            }
        }*/
    class KthLargest {
        Queue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int i :
                    nums) {
                add(i);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
