package contest.The289;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 10:27 on 2022/4/17 .
 */
public class Solution {
    public static void main(String[] args) {

        int[][] arr = {{824, 709, 193, 413, 701, 836, 727}, {135, 844, 599, 211, 140, 933, 205}, {329, 68, 285, 282, 301, 387, 231},
                {293, 210, 478, 352, 946, 902, 137}, {806, 900, 290, 636, 589, 522, 611}, {450, 568, 990, 592, 992, 128, 92}, {780, 653, 795, 457, 980, 942, 927}, {849, 901, 604, 906, 912, 866, 688}};
        System.out.println(new Solution().maxTrailingZeros(arr));

    }

    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = 0;
        int num = 0;

        while (s.length() > k) {
            for (int i = 0; i < s.length(); i++) {
                num += s.charAt(i) - '0';
                n++;
                if (n == k) {
                    sb.append(num);
                    n = 0;
                    num = 0;
                }
                if (i == s.length() - 1) {
                    if (n != 0) {
                        sb.append(num);
                        num = 0;
                        n = 0;
                    }
                }
            }
            s = sb.toString();
            sb = new StringBuilder();
        }
        return s;
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (value == 1) {
                return -1;
            } else {
                int a = value % 3;
                ans += value / 3;
                if (a % 2 == 0) {
                    ans += a / 2;
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] a52 = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = grid[i][j];
                while (temp % 5 == 0) {
                    temp /= 5;
                    a52[i][j][0]++;
                }
                while (temp % 2 == 0) {
                    temp /= 2;
                    a52[i][j][1]++;
                }
            }
        }

        int[][][] toleft = new int[m][n][2];
        int[][][] toright = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                toleft[i][j][0] += a52[i][j][0];
                toleft[i][j][1] += a52[i][j][1];
                if (j != 0) {
                    toleft[i][j][0] += toleft[i][j - 1][0];
                    toleft[i][j][1] += toleft[i][j - 1][1];
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                toright[i][j][0] += a52[i][j][0];
                toright[i][j][1] += a52[i][j][1];
                if (j + 1 < n) {
                    toright[i][j][0] += toright[i][j + 1][0];
                    toright[i][j][1] += toright[i][j + 1][1];
                }
            }
        }
        int[][][] totop = new int[m][n][2];
        int[][][] tobottom = new int[m][n][2];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                totop[i][j][0] += a52[i][j][0];
                totop[i][j][1] += a52[i][j][1];
                if (i > 0) {
                    totop[i][j][0] += totop[i - 1][j][0];
                    totop[i][j][1] += totop[i - 1][j][1];
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                tobottom[i][j][0] += a52[i][j][0];
                tobottom[i][j][1] += a52[i][j][1];
                if (i + 1 < m) {
                    tobottom[i][j][0] += tobottom[i + 1][j][0];
                    tobottom[i][j][1] += tobottom[i + 1][j][1];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[][] dir = new int[4][2];
                dir[0][0] = toleft[i][j][0];
                dir[0][1] = toleft[i][j][1];
                dir[1][0] = toright[i][j][0];
                dir[1][1] = toright[i][j][1];
                dir[2][0] = tobottom[i][j][0];
                dir[2][1] = tobottom[i][j][1];
                dir[3][0] = totop[i][j][0] ;
                dir[3][1] = totop[i][j][1] ;
                for (int k = 0; k < 2; k++) {
                    for (int l = 2; l < 4; l++) {
                        max = Math.max(max, Math.min((dir[k][0] + dir[l][0]- a52[i][j][0]), (dir[k][1] + dir[l][1]-a52[i][j][1])));
                    }
                }
            }
        }
        return max;
    }

    public int maxTrailingZeros0(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] a52 = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = grid[i][j];
                while (temp % 5 == 0) {
                    temp /= 5;
                    a52[i][j][0]++;
                }
                while (temp % 2 == 0) {
                    temp /= 2;
                    a52[i][j][1]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = j;
                int[][] dir = new int[4][2];
                while (++temp < n) {
                    dir[0][0] += a52[i][temp][0];
                    dir[0][1] += a52[i][temp][1];
                }
                temp = j;
                while (--temp >= 0) {
                    dir[1][0] += a52[i][temp][0];
                    dir[1][1] += a52[i][temp][1];
                }
                temp = i;
                while (++temp < m) {
                    dir[2][0] += a52[temp][j][0];
                    dir[2][1] += a52[temp][j][1];
                }
                temp = i;
                while (--temp >= 0) {
                    dir[3][0] += a52[temp][j][0];
                    dir[3][1] += a52[temp][j][1];
                }
                for (int k = 0; k < 2; k++) {
                    for (int l = 2; l < 4; l++) {
                        max = Math.max(max, Math.min((a52[i][j][0] + dir[k][0] + dir[l][0]), (a52[i][j][1] + dir[k][1] + dir[l][1])));
                    }
                }
            }
        }
        return max;
    }
}
