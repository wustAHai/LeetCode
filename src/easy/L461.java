package easy;

/**
 * Created by chenz at 22:33 on 2021/1/16
 */
public class L461 {
    public int hammingDistance(int x, int y) {
        x ^= y;
        int answer = 0;
        while (x != 0) {
            ++answer;
            x &= (x - 1);
        }
        return answer;
    }
}
