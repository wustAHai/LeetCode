package contest.The274;

import java.util.Arrays;

/**
 * @author chenz at 10:59 on 2022/1/2 .
 */
public class C5969 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (m <asteroids[i]){
                return false;
            }else {
                m+=asteroids[i];
            }
            if (m>=asteroids[asteroids.length-1]){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        C5969 ans = new C5969();
        int[] a = {5,6,1,4};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
