package contest;

import java.util.Arrays;

/**
 * @author chenz at 22:26 on 2022/9/17 .
 */
public class L87 {


    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] md = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < 12; i++) {
            md[i] += md[i - 1];
        }
        int aa = getDay(arriveAlice, md);
        int la = getDay(leaveAlice, md);
        int ab = getDay(arriveBob, md);
        int lb = getDay(leaveBob, md);
        if (la < ab || lb < aa) {
            return 0;
        }
        //273 -
        return Math.min(lb, la) - Math.max(aa, ab) + 1;

    }

    int getDay(String s, int[] md) {
        Integer m = Integer.valueOf(s.substring(0, 2));
        int d = 0;
        if (m > 1) {
            d += md[m - 2];
        }
        d += Integer.valueOf(s.substring(3));
        return d;
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        for (int i = 0, j = 0; i < players.length && j < trainers.length; ) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                ans++;
            } else {
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        L87 l87 = new L87();
        int[] ints = l87.smallestSubarrays(new int[]{1,0,2,1,3});
        System.out.println(ints);
    }

    public int[] smallestSubarrays(int[] nums) {
        int[] max = new int[nums.length];
        max[nums.length - 1] = nums[nums.length - 1];
        for (int i = max.length - 2; i >= 0; i--) {
            max[i] = nums[i] | max[i + 1];
        }
        int[] ints = new int[32];
        int[] ans = new int[nums.length];
        for (int i = 0, j = -1; i < nums.length; i++) {
            if (j<i){
                add(ints,nums[i]);
            }
            int ints1 = getInts(ints);
            if (ints1 < max[i]) {
                int temp = ints1;
                j=Math.max(i,j);
                while (temp < max[i]) {
                    j++;
                    temp = temp | nums[j];
                    add(ints, nums[j]);
                }
            }
            if (j>=i){
                ans[i] = j - i + 1;
            }else {
                ans[i] = 1;
            }
            minus(ints,nums[i]);
        }
        return ans;
    }

    void add(int[] ints, int temp) {
        int i = 0;
        while (temp > 0) {
            ints[i++] += temp & 1;
            temp >>= 1;
        }
    }

    void minus(int[] ints, int temp) {
        int i = 0;
        while (temp > 0) {
            ints[i++] -= temp & 1;
            temp >>= 1;
        }
    }

    int getInts(int[] ints) {
        int a = 0;
        int t =1;
        for (int i = 0; i < 31; i++) {
            a += ints[i] > 0 ? t : 0;
            t<<=1;
        }
        return a;
    }

}
