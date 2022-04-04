package mid;

public class L1109 {

    public int[] corpFlightBookings0(int[][] bookings, int n) {
        int[]  ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                ans[j] +=bookings[i][2];
            }
        }
        return ans;
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]  ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            ans[bookings[i][0]-1] += bookings[i][2];
            if (bookings[i][1]<n){
                ans[bookings[i][1]] -= bookings[i][2];
            }
        }
        for (int i = 1; i < ans.length; i++) {
            ans[i]+=ans[i-1];
        }
        return ans;
    }

}
