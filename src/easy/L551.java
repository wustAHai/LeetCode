package easy;

/**
 * Created by chenz at 10:12 on 2021/1/23
 */
public class L551 {
    public boolean checkRecord(String s) {
        char[] record = s.toCharArray();
        int a = 0;
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            } else if (record[i] == 'L') {
                if (i < record.length - 2 && record[i + 1] == 'L' && record[i + 2] == 'L') {
                    return false;
                }
            }
        }
        return true;
    }
}
