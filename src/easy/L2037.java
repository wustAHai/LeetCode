package easy;

import java.util.Arrays;

/**
 * @author chenz at 12:02 on 2023/1/1 .
 */
public class L2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans+=Math.abs(seats[i]-students[i]);
        }
        return ans;
    }
}
