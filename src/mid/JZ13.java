package mid;

/**
 * Created by chenz at 7:06 on 2021/2/4
 */
public class JZ13 {
    int counter = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        movingTo(0, 0, visited, k);
        return counter;
    }

    private void movingTo(int m, int n, boolean[][] visited, int k) {
        if (m < 0 || m > visited.length || n < 0 || n > visited[0].length) {
            return;
        }
        if (visited[m][n]) {
            return;
        }
        if (getNum(m) + getNum(n) > k) {
            return;
        }
        visited[m][n] = true;
        counter++;
        movingTo(m + 1, n, visited, k);
        movingTo(m - 1, n, visited, k);
        movingTo(m, n + 1, visited, k);
        movingTo(m, n - 1, visited, k);
    }

    int getNum(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
