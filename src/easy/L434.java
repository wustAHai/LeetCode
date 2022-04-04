package easy;

/**
 * Created by chenz at 14:45 on 2021/1/7
 */
public class L434 {
    public int countSegments(String s) {
        boolean status = false;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (status) {
                    status = false;
                }
            } else {
                if (!status) {
                    status = true;
                    n++;
                }
            }
        }
        return n;
    }
}
