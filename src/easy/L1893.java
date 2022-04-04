package easy;

public class L1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int i = 0; i < ranges.length; i++) {
            diff[ranges[i][0]]++;
            diff[ranges[i][1]+1]--;
        }
        int num = 0;
        for (int i = 1; i <= right ; i++) {
            num+=diff[i];
            if (num<=0&&i>=left){
                return false;
            }
        }
        return true;
    }
}
