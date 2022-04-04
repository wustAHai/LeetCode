package contest.The231;

import org.junit.Test;

/**
 * Created by chenz at 10:41 on 2021/3/7
 */
public class C5697 {
    public boolean checkOnesSegment(String s) {
        int i=0;
        while (i<s.length()&&s.charAt(i)=='1'){
            i++;
        }
        while (i<s.length()&&s.charAt(i)=='0'){
            i++;
        }
        if (i==s.length()){
            return true;
        }else {
            return false;
        }
    }

    @Test
    public void test(){
        System.out.println(checkOnesSegment("1"));
    }
}
