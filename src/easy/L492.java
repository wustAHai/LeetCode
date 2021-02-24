package easy;

/**
 * Created by chenz at 10:36 on 2021/1/19
 */
public class L492 {
    public int[] constructRectangle(int area) {
        int i = (int) Math.sqrt(area);
        for (; i >= 1; i--) {
            if (area % i == 0) {
                break;
            }
        }
        return new int[]{area / i, i};
    }
}
