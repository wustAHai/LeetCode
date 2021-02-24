package contest;

import org.junit.Test;

/**
 * Created by chenz at 10:31 on 2021/1/24
 */
public class C5661 {
    //19-23  50 - 59
    public String maximumTime(String time) {
        char[] timeCh = time.toCharArray();
        if (timeCh[0] == '?') {
            if (timeCh[1] == '?') {
                timeCh[0] = '2';
                timeCh[1] = '3';
            } else {
                if (timeCh[1] < '4') {
                    timeCh[0] = '2';
                } else {
                    timeCh[0] = '1';
                }
            }
        } else {
            if (timeCh[1] == '?') {
                if (timeCh[0] == '2') {
                    timeCh[1] = '3';
                } else {
                    timeCh[1] = '9';
                }
            }
        }
        if (timeCh[3] == '?') {
            timeCh[3] = '5';
        }
        if (timeCh[4] == '?') {
            timeCh[4] = '9';
        }
        return new String(timeCh);
    }

    @Test
    public void test() {
        System.out.println(maximumTime("1?:22"));
    }
}
